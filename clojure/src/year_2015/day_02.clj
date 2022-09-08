(ns year-2015.day-02
  (:require [clojure.string :as str]))

(defn wrapping-paper
  [l w h]
  (let [lw (* l w)
        wh (* w h)
        hl (* h l)]
    (+ (* 2 lw) (* 2 wh) (* 2 hl) ; wrapping paper
       (min lw wh hl)))) ; slack

(defn part-1
  [input]
  (reduce (fn [acc curr]
            (let [v (map #(Integer/parseInt %)
                         (str/split curr #"x"))
                  l (first v)
                  w (second v)
                  h (last v)]
              (+ acc (wrapping-paper l w h))))
          0
          (str/split-lines input)))
