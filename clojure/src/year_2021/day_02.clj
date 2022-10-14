(ns year-2021.day-02
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]))

#_(comment
    (def input (slurp "resources/year-2021/day-02/input.txt")))

(defn parsed-input [input]
  (read-string
   (pp/cl-format nil "[~{{:~a} ~}]" (str/split-lines input))))

;; Part 1
(defn steps [input direction]
  (filter direction (parsed-input input)))

(defn position [input direction]
  (reduce + (map direction (steps input direction))))

(defn hpos
  [input]
  (position input :forward))

(defn depth
  [input]
  (- (position input :down)
     (position input :up)))

(defn part-1
  [input]
  (* (hpos input) (depth input)))

;; Part 2
(defn aim
  [input]
  (- (position input :down)
     (position input :up)))

(defn depth-new
  [input]
  (* (aim input)
     (position input :forward)))

(defn part-2
  [input])

(defn -main
  [& args]
  (let [input (slurp (first args))]
    (condp some args
      #(= ":one" %) (part-1 input)
      #(= ":two" %) (println "Not Working")
      #(= ":both" %) (let [part-1 (part-1 input)
                           part-2 (println "Not Working")]
                       (println "Answer:"
                                "\n  part-1:" part-1
                                "\n  part-2:" part-2)))))