(ns webapp.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.reload :refer [wrap-reload]]
   [reitit.ring :refer [create-default-handler ring-handler router]]))

(defn ok [body] {:body body :headers {"Content-Type" "text/html"} :status 200})

(defn handler [_req] (ok "<h1>Hello, world!</h1>"))

(defn will-it-blend [_] (ok "<h1>Will it blend?</h1>"))

(def app
  (ring-handler (router [["/" {:get {:handler handler}}] ;;
                         ["/willit" {:get {:handler will-it-blend}}]])
                (create-default-handler)))

(defn -main [& args] (run-jetty (wrap-reload #'app) {:port 3000}))
