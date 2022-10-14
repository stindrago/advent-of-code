(ns year-2020.day-01
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

#_(comment
    (def input
      (map #(Integer/parseInt %) (str/split-lines  (slurp "resources/year-2020/day-01/input.txt")))))

;;; Part 1
(defn combinations-of-2
  [input]
  (vec (combo/combinations input 2)))

(defn sum-of-combinations-of-2
  [input]
  (vec (map #(apply + %) (combinations-of-2 input))))

(defn part-1
  [input]
  (apply * (get (combinations-of-2 input) (.indexOf (sum-of-combinations-of-2 input) 2020))))

;;; Part 2
(defn combinations-of-3
  [input]
  (vec (combo/combinations input 3)))

(defn sum-of-combinations-of-3
  [input]
  (vec (map #(apply + %) (combinations-of-3 input))))

(defn part-2
  [input]
  (apply * (get (combinations-of-3 input)
                (.indexOf (sum-of-combinations-of-3 input) 2020))))

(defn -main
  [& args]
  (let [input
        (map #(Integer/parseInt %) (str/split-lines (slurp (first args))))]
    (condp some args
      #(= ":one" %) (part-1 input)
      #(= ":two" %) (part-2 input)
      #(= ":both" %) (let [part-1 (part-1 input)
                           part-2 (part-2 input)]
                       (println "Answer:"
                                "\n  part-1:" part-1
                                "\n  part-2:" part-2)))))