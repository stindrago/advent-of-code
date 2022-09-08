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

(defn part-2
  [input]
  (reduce (fn [acc curr]
            (let  [v (map #(Integer/parseInt %)
                          (str/split curr #"x"))
                   l (first v)
                   w (second v)
                   h (last v)
                   sorted-v (sort v)
                   a (first sorted-v)
                   b (second sorted-v)
                   shortest-perimeter (+ (* 2 a) (* 2 b))]
              (+ acc shortest-perimeter (* l w h))))
          0
          (str/split-lines input)))
