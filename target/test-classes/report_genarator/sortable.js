/**
 * sortable 1.0
 * Copyright 2017 Jonas Earendel
 * This is free and unencumbered software released into the public domain.*/
!function () { var e = " dir-down", a = " dir-up", r = /\bsortable\b/; document.addEventListener("click", function (l) { var n = l.target; if ("TH" == n.nodeName) { var c = n.parentNode, o = c.parentNode.parentNode; if (r.test(o.className)) { for (var t, s = c.cells, i = 0; i < s.length; i++)s[i] === n ? t = i : s[i].className = s[i].className.replace(e, "").replace(a, ""); var d = n.className, p = e; -1 == d.indexOf(e) ? d = d.replace(a, "") + e : (p = a, d = d.replace(e, "") + a), n.className = d; var N = o.tBodies[0], f = N.cloneNode(!0), v = Array.prototype.slice.call(f.rows, 0); v.sort(function (e, r) { if (e = e.cells[t].innerText, r = r.cells[t].innerText, p == a) { var l = e; e = r, r = l } return isNaN(e - r) ? e.localeCompare(r) : e - r }); var m = f.cloneNode(); for (i = 0; i < v.length; i++)m.appendChild(v[i]); o.replaceChild(m, N) } } }) }();
