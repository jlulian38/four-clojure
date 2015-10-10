(ns four-clojure.core-test
  (:require [clojure.test :refer :all]
            [four-clojure.core :refer :all]))

(deftest p58-test
  (testing "4clojure problem 58")
  (is (= [3 2 1] ((p58 rest reverse) [1 2 3 4]))))


(deftest p121-test
  (testing "4clojure problem 121"
    (is (= 2 ((p121 '(/ a b))
              '{b 8 a 16})))
    (is (= 8 ((p121 '(+ a b 2))
              '{a 2 b 4})))
    (is (= [6 0 -4]
           (map (p121 '(* (+ 2 a)
                        (- 10 b)))
                '[{a 1 b 8}
	          {b 5 a -2}
	          {a 2 b 11}])))
    (is (= 1 ((p121 '(/ (+ x 2)
                      (* 3 (+ y 1))))
              '{x 4 y 1})))))
