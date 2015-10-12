(ns four-clojure.core-test
  (:require [clojure.test :refer :all]
            [four-clojure.core :refer :all]))

(deftest p58-test
  (testing "4clojure problem 58")
  (is (= [3 2 1] ((p58 rest reverse) [1 2 3 4]))))

(deftest p69-test
  (testing "4clojure problem 69")
  (is (= (p69 * {:a 2, :b 3, :c 4} {:a 2 :d 5})
         {:a 4 :b 3 :c 4 :d 5}))
  (is (= (p69 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
         {:a 4, :b 6, :c 20}))
  (is (= (p69 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
         {:a [3 4 5], :b [6 7], :c [8 9]})))


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
