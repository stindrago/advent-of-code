(ns aoc-2020.core
  (:gen-class))

(set! *warn-on-reflection* true)

(defn run-problem [n]
  (let [day (.format (new java.text.DecimalFormat "0") n)
        solution-function (symbol (str "solution-d" day))]
    (use (vec (list (symbol (str "aoc-2020.d" day))
                    :only (list solution-function))))
    (eval (list solution-function))))

(defn -main
  "Solution runner"
  [& args]
  (if (and args (= 1 (count args)))
    (println (time (run-problem (Integer/parseInt (first args)))))
    (println "Usage: lein run [day]")))
