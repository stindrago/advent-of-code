(ns year-2015.day-05
  (:require [clojure.string :as str]))

(comment
  (def dummy "qjhvhtzxzqqjkmpb\nxxyxx\nuurcxstgmygtbstg\nieodomkazucvgmuy")
  (def input (slurp "./resources/year-2015/day-05/input.txt")))

(def vowels (set "aeiou"))
(def banned-strings (set ["ab" "cd" "pq" "xy"]))

(defn rule-1
  "It contains at least three vowels."
  [s]
  (if (<= 3 (count
             (filter true?
                     (map #(if (vowels %1) true false) (seq s)))))
    true
    false))

(defn rule-2
  "It contains at least one letter that appears twice in a row."
  [s]
  (loop [v (seq s)]
    (if (> (count v) 1)
      (if (= (str/join (take 2 (repeat (first v))))
             (str (first v)
                  (second v)))
        true
        (recur (rest v)))
      false)))

(defn rule-3
  "It does not contain the `banned-strings`."
  [s]
  (loop [v (seq s)]
    (if (> (count v) 1)
      (if (banned-strings (str (first v) (second v)))
        false
        (recur (rest v)))
      true)))

(defn part-1
  [input]
  (count
   (filter true?
           (reduce (fn [acc curr]
                     (println [(rule-1 curr)
                               (rule-2 curr)
                               (rule-3 curr)])
                     (conj acc (every? true?
                                       [(rule-1 curr)
                                        (rule-2 curr)
                                        (rule-3 curr)])))
                   []
                   (str/split-lines input)))))

;; part-2

(defn rule-4
  "It contains a pair of any two letters that appears at least twice in the string without overlapping."
  [s]
  (if
   (when   ;;overlaps?
    (when-not (some true?
                    (for [x (partition 3 1 s)]
                      (= (first x)
                         (second x)
                         (last x))))
      true)
    ;;pairs?
     (when (>=
            (count
             (filter true?
                     (for [x (partition 2 1 s)]
                       (>=
                        (count
                         (filter #(= x %)
                                 (partition 2 1 s)))
                        2))))
            2)
       true))
    true
    false))

(defn rule-5
  "It contains at least one letter which repeats with exactly one letter between them."
  [s]
  (if
   (some true?
         (for [x (partition 3 1 s)]
           (= (first x)
              (last x))))
    true
    false))

(defn part-2
  [input]
  (count
   (filter true?
           (reduce (fn [acc curr]
                     #_(println "acc" acc)
                     #_(println [(rule-4 curr)
                                 (rule-5 curr)])
                     (conj acc (every? true?
                                       [(rule-4 curr)
                                        (rule-5 curr)])))
                   []
                   (str/split-lines input)))))

(defn -main
  [& args]
  (let [input (slurp (first args))]
    (condp some args
      #(= ":one" %) (part-1 input)
      #(= ":two" %) (println "Not Working!")
      #(= ":both" %) (let [part-1 (part-1 input)
                           part-2 (println "Not Working!")]
                       (println "Answer:"
                                "\n  part-1:" part-1
                                "\n  part-2:" part-2)))))