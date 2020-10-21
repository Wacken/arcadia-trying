(ns scripts.core
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l])
  (:import [UnityEngine Vector3]))

(defonce c (create-primitive :cube))
(def offset (Vector3. 0.01 0 0))

(defn move!
  [go v3]
  (set! (.. go transform position)
        (l/v3+ (.. go transform position)
               v3)))

(defn def-move!
  [go _]
  (let [offset (Vector3. 0.01 0 0)]
    (move! go offset)))

(hook+ c :update :move #'def-move!)
