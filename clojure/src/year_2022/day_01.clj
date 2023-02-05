(ns year-2022.day-01
  (:require [clojure.string :as str]))

(comment
  "1000
2000
3000

4000

5000
6000

7000
8000
9000

10000")

#_(comment
    (def dummy ["1000"
                "2000"
                "3000"
                ""
                "4000"
                ""
                "5000"
                "6000"
                ""
                "7000"
                "8000"
                "9000"
                ""
                "100000"])
    (def input (str/split-lines (slurp "resources/year-2022/day-01/input.txt"))))

(defn partition-calories [input]
  (filter (fn [x]
            (seq (first x)))
          (partition-by empty? input)))

(defn parse-calories->int [input]
  (for [s input] 
  (map #(Integer/parseInt %) s)))

(defn calories-per-elf [input]
  (map #(apply + %) input))

(defn elf-with-most-calories [input]
  (apply max input))

(defn part-1 [input]
  "The elf with most calories."
  (-> input
      partition-calories
      parse-calories->int
      calories-per-elf
      elf-with-most-calories))

(defn part-2 [input]
  "The sum of the 3 elfs with most calories."
  (->> input
       partition-calories
       parse-calories->int
       calories-per-elf
       sort
       (take-last 3)
       (reduce +)))

(defn -main
  [& args]
  (let [input
        (str/split-lines (slurp (first args)))]
    (condp some args
      #(= ":one" %) (part-1 input)
      #(= ":two" %) (part-2 input)
      #(= ":both" %) (let [part-1 (part-1 input)
                           part-2 (part-2 input)]
                       (println "Answer:"
                                "\n  part-1:" part-1
                                "\n  part-2:" part-2)))))
