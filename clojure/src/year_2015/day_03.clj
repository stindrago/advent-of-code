(ns year-2015.day-03)

(comment
  (def dummy [[-1 0] [0 1] [1 1] [1 1] [1 0]])
  (def input (slurp "./resources/year-2015/day-03/input.txt")))
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