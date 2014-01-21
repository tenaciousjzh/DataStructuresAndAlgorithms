(ns
  ^{:author Jared}
  org.bytescale.algorithms.euclid)

(defn gcd
  "Compute the greatest common divisor of two nonnegative integers, p and q
  as follows:
  If q is 0, then the answer is p. If not, divide p by q and take the remainter
  r. The answer is the greates common divisor of q and r (recursive)"
  [p q]
  (if (= q 0)
    ;base case q is zero
    p
    ;else recurse
    (let [r (mod p q)]
      (gcd q r)
      )
    )
  )
