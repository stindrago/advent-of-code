(ns aoc-2020.1
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.math.combinatorics :as combo]))

(def example-input [1721
                    979
                    366
                    299
                    675
                    1456])

(def input
  (map #(Integer/parseInt %)
       (line-seq (io/reader "resources/input/d1.txt"))))

(def combinations
  (vec (combo/combinations input 2)))

(def sum-of-combinations
  (vec (map #(apply + %) combinations)))

(defn solution-1 []
  (apply * (get combinations (.indexOf sum-of-combinations 2020))))
;; => 1019571
