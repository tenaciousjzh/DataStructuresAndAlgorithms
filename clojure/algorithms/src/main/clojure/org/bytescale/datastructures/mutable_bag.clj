(ns
  ^{:author Jared}
  org.bytescale.datastructures.standard-bag
  (:require [org.bytescale.datastructures.spec.bag :as spec])
  (:import [clojure.lang ITransientCollection]))

(defrecord MutableBag [^ITransientCollection list]
  spec/Bag
  (add-item [this item]
    (conj! list item))
  (is-empty? [this]
    (if (= 0 (count list))
      true
      false))
  (num-items [this]
    (count list))
  )

;(in-ns 'org.bytescale.datastructures.standard-bag)
;(def my-bag (->StandardBag [1 2]))