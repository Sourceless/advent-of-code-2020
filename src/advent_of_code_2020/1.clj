(ns advent-of-code-2020.1)

(def input
  (map #(Integer/parseInt %)
       (clojure.string/split-lines (slurp "data/1.txt"))))

(def sorted-input
  (sort input))

(defn find-2020
  ([input]
   (find-2020 (first input) (last input) (rest (butlast input))))
  ([small big remaining]
   (let [small-big-sum (+ small big)]
     (prn small-big-sum)
     (cond
       (> 2020 small-big-sum) (find-2020 (first remaining) big (rest remaining))
       (< 2020 small-big-sum) (find-2020 small (last remaining) (butlast remaining))
       (= 2020 small-big-sum) [small big]))))

(def numbers
  (find-2020 sorted-input))

(def part-1-answer
  (reduce * numbers))
