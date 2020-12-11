;;;; Day 1

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
       (line-seq (io/reader "resources/input/d01.txt"))))


;;; Part 1
(def combinations-of-2
  (vec (combo/combinations input 2)))

(def sum-of-combinations-of-2
  (vec (map #(apply + %) combinations-of-2)))

;;; Part 2
(def combinations-of-3
  (vec (combo/combinations input 3)))

(def sum-of-combinations-of-3
  (vec (map #(apply + %) combinations-of-3)))

;;; Solutions
(defn solution-1 []
  (println "Puzzle 1 solution: "
           (apply * (get combinations (.indexOf sum-of-combinations-of-2 2020))))
  (println "Puzzle 2 solution: "
           (apply * (get combinations (.indexOf sum-of-combinations-of-3 2020)))))

