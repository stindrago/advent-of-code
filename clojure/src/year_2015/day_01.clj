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
