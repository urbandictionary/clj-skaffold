(ns webapp.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.reload :refer [wrap-reload]]
   [reitit.ring :refer [create-default-handler ring-handler router]]))

(defn handler [_req] {:body "<h1>Hello, world!</h1>" :headers {"Content-Type" "text/html"} :status 200})

(defn will-it-blend [_] {:body "<h1>Will it blend?</h1>" :headers {"Content-Type" "text/html"} :status 200})

(def app
  (ring-handler (router [["/" {:get {:handler handler}}] ;;
                         ["/willit" {:get {:handler will-it-blend}}]])
                (create-default-handler)))

(defn -main [& args] (run-jetty (wrap-reload #'app) {:port 3000}))
