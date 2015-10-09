(ns four-clojure.core)

(def p121 (fn [form]
       (fn [env]
         (let [ops {'* * '/ / '+ + '- -}
               my-eval (fn my-eval
                         [env form]
                         (cond (symbol? form) (env form)
                               (number? form) form
                               (seq? form) (apply
                                            (env (first form))
                                            (map (partial my-eval env)
                                                 (rest form)))))]
           (my-eval (merge env ops) form)))))
