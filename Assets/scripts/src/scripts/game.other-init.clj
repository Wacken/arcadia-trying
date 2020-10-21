(ns game.other-init
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l]
            [arcadia.introspection :as i])
  (:import
   [UnityEngine Application
    QualitySettings]))

(defn init-fps!
  [& _]
  (set! (.. QualitySettings vSyncCount) 0)
  (set! (.. Application targetFrameRate) 15))

(init-fps!)

(hook+ (object-named "Main Camera")
       :start
       :set-fps
       #'init-fps!)

(defn clear-scene!
  [go]
  (doseq [c (children go)]
    (destroy c)))

(defn init!
  [& _]
  (let [holder (object-named "Beholder")
        c1 (create-primitive :cube)]
    (clear-scene! holder)
    (child+ holder c1)
    (set! (.. c1 transform position)
          (l/v3 0 0 0))))

(init!)
