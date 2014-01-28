(ns
  ^{:author Jared}
  org.bytescale.datastructures.tests.bag-test
  (:require [clojure.test]
            [org.bytescale.datastructures.mutable-bag]))

(with-test
  (def my-bag (->MutableBag (transient [])))
  (is (.is-empty? my-bag))
  )

(with-test
  (defn get-count-after-add[item-val]
    (let [my-bag (->StandardBag (transient []))
          _ (.add-item my-bag item-val)]
      (.num-items my-bag)
      )
    )
  (is (= 1 (get-count-after-add 1)))
  )
