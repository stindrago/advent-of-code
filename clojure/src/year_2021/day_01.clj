(ns year-2021.day-01
  (:require [clojure.string :as str]))

#_(comment
    (def input
      (map #(Integer/parseInt %) (str/split-lines  (slurp "resources/year-2021/day-01/input.txt")))))

;; Part 1
(defn increased? [input]
  (map > (rest input) input))

(defn count-incresed [input]
  (count (remove false? input)))

(defn part-1
  [input]
  (count-incresed (increased? input)))

;; Part 2
(defn group-items [input]
  (partition 3 1 input))

(defn sum-groups [input]
  (map #(apply + %)
       (partition 3 1 input)))

(defn part-2
  [input]
  (count-incresed (increased? (sum-groups input))))

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