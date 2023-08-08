(ns picture-gallery.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [picture-gallery.routes.home :refer [home-routes]]
            [picture-gallery.routes.auth :refer [auth-routes]]
            [noir.util.middleware :as noir-middleware]))

(defn init []
  (println "picture-gallery is starting"))

(defn destroy []
  (println "picture-gallery is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (noir-middleware/app-handler [auth-routes home-routes app-routes]))

;(def app
;  (-> (routes home-routes app-routes auth-routes)
;      (handler/site)
;      (wrap-base-url)))
