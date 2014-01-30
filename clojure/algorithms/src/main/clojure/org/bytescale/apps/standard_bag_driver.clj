(ns
  ^{:author Jared}
  org.bytescale.apps.standard-bag-driver
   (:use [org.bytescale.datastructures.standard-bag])
  )

(defn std [num-list]
  (let [N (count num-list)
        mean (/ (apply + num-list) N)
        sum (apply + (map #(+ (* (- % mean) (- % mean))) num-list))]
    (Math/sqrt (/ sum (- N 1)))
    )
  )

(defn main [args]
  ;Read in the numbers from user input and store them in the bag
  (let [_ (println "Enter the numbers into the bag: ")
         bag (->StandardBag (map #(Double/parseDouble %) (clojure.string/split (read-line) #"\s+")))
        standard-deviation (std bag)
        mean (/ (apply + bag) (.count bag))]
    (println (str "Bag elements: " (.toString bag) "\n"
               " Mean: " mean "\n"
               " Standard Deviation: " standard-deviation))
    )
  )


