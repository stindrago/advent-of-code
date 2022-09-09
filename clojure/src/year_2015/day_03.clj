(ns year-2015.day-03)

(comment
  (def dummy [[-1 0] [0 1] [1 1] [1 1] [1 0]])
  (def input (slurp "./resources/year-2015/day-03/input.txt")))

(def direction {\^ :north
                \v :south
                \> :east
                \< :west})

(defn direction-coordinates
  "[x y]"
  [direction]
  (condp = direction
    :north [0 1]
    :south [0 -1]
    :east [1 0]
    :west [-1 0]))

(defn input-coordinates
  [input]
  (let [v (seq input)]
    (reduce (fn [acc curr]
              (conj acc
                    (direction-coordinates (get direction curr))))
            []
            v)))

(defn next-point
  [previous direction]
  (mapv + previous direction))

(defn pin-point
  "Pin the points on the grid. Each point is the house visited. Multpple occurances of the same point are the house visited multiple times."
  [v]
  (reduce (fn [pinned-points direction]
            (conj pinned-points
                  (next-point (last pinned-points) direction)))
          [[0 0]]
          v))

(defn part-1
  "Count the houses visited."
  [input]
  (count (set (pin-point (input-coordinates input)))))

;; part-2

(defn separate-path
  "Partition path in tuples. [:santa :robo-santa]"
  [input]
  (partition 2 (seq input)))

(defn get-path-of
  [who v]
  (condp = who
    :santa (reduce (fn [acc curr]
                     (conj acc (first curr)))
                   []
                   v)
    :robo-santa (reduce (fn [acc curr]
                          (conj acc (last curr)))
                        []
                        v)))

(defn part-2
  [input]
  (count (set (concat
               (pin-point (input-coordinates (get-path-of :santa (separate-path input))))
               (pin-point (input-coordinates (get-path-of :robo-santa (separate-path input))))))))

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