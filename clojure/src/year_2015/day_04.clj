(ns year-2015.day-04
  (:require [clj-commons.digest :as digest]))

(defn find-right-hash
  [input zeros]
  (loop [curr 0]
    (println curr)
    (if (every? zero? (map #(Character/digit % 10)
                           (take zeros (digest/md5
                                        (str input curr)))))
      curr
      (recur (inc curr)))))
(defn -main
  [& args]
  (let [input (slurp (first args))]
    (condp some args
      #(= ":one" %) (part-1 input)
      #(= ":two" %) (part-2 input)
      #(= ":both" %) (let [part-1 (part-1 input)
                           part-2 (part-2 input)]
                       (println "Answer:"
                                "\n  part-1:" part-1
                                "\n  part-2:" part-2)))))