(ns year-2015.day-01)

(def dummy "()((")
(def floor-up \() ; kinda ugly 🤣

#_(comment
    (def input (slurp "resources/year-2015/day-01/input.txt"))

  ;; BEST - Reduce
    (reduce (fn [acc curr]
              (if (= floor-up curr) (inc acc) (dec acc)))
            0
            (seq input))

  ;; BAD - Recursive function
    (defn part-1 [acc coll]
      (println "Looking for appartament on floor:" acc)
      (if (empty? coll)
        (println "The appartament is on floor:" acc)
        (part-1
         (if (= floor-up (first coll))
           (inc acc)
           (dec acc))
         (rest coll)))))

;; GOOD - Tail recursion
(defn part-1
  [input]
  (loop [acc 0
         coll (seq input)]
    (println "Looking for appartament on floor:" acc)
    (if (empty? coll)
      (do
        (println "The appartament is on floor:" acc)
        acc)
      (recur
       (if (= floor-up (first coll))
         (inc acc)
         (dec acc))
       (rest coll)))))

(defn part-2
  [input]
  (loop [acc 0
         pos 0
         coll (seq input)]
    (println "Looking for appartament on floor:" acc)
    (println "Checking if basement hit:" pos)
    (if (neg? acc)
      (do (println "Basement hit at:" pos)
          pos)
      (recur
       (if (= floor-up (first coll))
         (inc acc)
         (dec acc))
       (inc pos)
       (rest coll)))))
