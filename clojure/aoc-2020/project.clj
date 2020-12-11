(defproject aoc-2020 "0.1.0-SNAPSHOT"
  :description "Advent Of Code 2020"
  :url "https://gitlab.com/stindrago/advent-of-code/-/tree/master/clojure/aoc-2020/"
  :license {:name "The Unlicense"
            :url "https://unlicense.org"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clojure.java.io :as io]
                 [clojure.math.combinatorics :as combo]]
  :main ^:skip-aot aoc-2020.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
