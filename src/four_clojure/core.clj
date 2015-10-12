(ns four-clojure.core)

(def p58
  (fn p58
    ([] identity)
    ([f] f)
    ([f g] (fn [& args] (f (apply g args))))
    ([f g & fs] (reduce p58 (list* f g fs)))))

(def p69 (fn p69
           ([f l r]
            (let [lkeys (keys l)
                  rkeys (keys r)
                  common (filter (set lkeys) rkeys) ; behaves like intersection
                  lcom (map l common)
                  rcom (map r common)]
              (merge l r (zipmap common (map #(f %1 %2) lcom rcom)))))
           ([f l r & maps]
            (reduce (partial p69 f) (into [l r] maps)))))

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
