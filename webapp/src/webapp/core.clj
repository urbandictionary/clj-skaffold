(ns webapp.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.reload :refer [wrap-reload]]
   [reitit.ring :refer [create-default-handler ring-handler router]]))

(defn handler [_req] {:body "<h1>1</h1>" :headers {"Content-Type" "text/html"} :status 200})

(def app (ring-handler (router ["/" {:get {:handler handler}}]) (create-default-handler)))

(defn -main [& args] (run-jetty (wrap-reload #'app) {:port 3000}))
