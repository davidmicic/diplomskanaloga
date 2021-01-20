(this["webpackJsonpdiplomska-react"]=this["webpackJsonpdiplomska-react"]||[]).push([[0],{26:function(e,t,a){e.exports=a(41)},31:function(e,t,a){},33:function(e,t,a){},34:function(e,t,a){},41:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),r=a(11),c=a.n(r),o=a(1),i=a(24),u=a(5),s=a(13);a(31);function m(e){var t=e.label,a=e.selected,r=e.onChange,c=e.name,i=Object(n.useState)(a),u=Object(o.a)(i,2),s=u[0],m=u[1];return Object(n.useEffect)((function(){m(a)}),[a]),l.a.createElement("div",null,l.a.createElement("label",null,l.a.createElement("input",{type:"checkbox",name:c,checked:s,value:a,onChange:function(e){var t=e.target.checked;m(t),r(t)}}),"\xa0",t))}var d=a(3);function f(e){var t=e.results,a=e.choosenElement;return l.a.createElement("div",{className:"border scrollBar"},t&&t.length>0&&t.map((function(e,t){return l.a.createElement("div",{className:"border-bottom",key:t,onClick:function(){return a(e)}},e)})))}var p=a(17),E=a.n(p);function v(e){var t=e.numberOfPages,a=e.page,r=e.filtirajClick,c=Object(n.useState)(a),i=Object(o.a)(c,2),u=i[0],s=i[1];return l.a.createElement("div",{className:""},l.a.createElement("div",{className:"d-flex flex-row align-items-center"},l.a.createElement("i",{className:"fas fa-chevron-circle-left fa-2x",onClick:function(){r(1),s(1)}}),l.a.createElement("i",{className:"fas fa-angle-left fa-2x",onClick:function(){u-1>=1&&(r(u-1),s(u-1))}}),l.a.createElement("div",{className:"border d-flex flex-row align-items-center px-3",style:{width:"70px"}},l.a.createElement("div",null,u),l.a.createElement("div",null,"/"),l.a.createElement("div",null,t)),l.a.createElement("i",{className:"fas fa-angle-right fa-2x",onClick:function(){u+1<=t&&(r(u+1),s(u+1))}}),l.a.createElement("i",{className:"fas fa-chevron-circle-right fa-2x",onClick:function(){r(t),s(t)}})))}function b(e){var t=e.diplomskaDela,a=e.page,r=e.numberOfPages,c=e.readOnly,i=e.catalogue,u=e.reFetchDiplomskaDela,s=e.studentSearch,m=e.filtirajClick,p=Object(n.useState)(!1),b=Object(o.a)(p,2),h=b[0],j=b[1],g=Object(n.useState)({}),O=Object(o.a)(g,2),y=O[0],x=O[1],k=Object(n.useState)(),N=Object(o.a)(k,2),C=N[0],S=N[1],w=Object(n.useState)(),D=Object(o.a)(w,2),T=D[0],P=D[1];return l.a.createElement("div",null,l.a.createElement("table",{className:"table table-striped table-dark"},l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",{scope:"col"}),l.a.createElement("th",{scope:"col"},"Avtor"),l.a.createElement("th",{scope:"col"},"Program"),l.a.createElement("th",{scope:"col"},"Naslov"),l.a.createElement("th",{scope:"col"},"Datum"),l.a.createElement("th",{scope:"col"},"Mentor"),l.a.createElement("th",{scope:"col"},"Zavod"),l.a.createElement("th",{scope:"col"},"Redni / Izredni"))),l.a.createElement("tbody",null,t&&t.map((function(e,t){var n;return h!==e.id?l.a.createElement("tr",{key:t},l.a.createElement("td",null,a?30*a+t+1-30:t+1,"."),l.a.createElement("td",null,e.dijak),l.a.createElement("td",null,e.program),l.a.createElement("td",null,e.naslov),l.a.createElement("td",null,e.datum),l.a.createElement("td",null,e.profesor),l.a.createElement("td",null,e.zavod),l.a.createElement("td",null,e.vrstaStudija),l.a.createElement("td",null,!c&&h!==e.id&&l.a.createElement("i",{className:"fas fa-pencil-alt",onClick:function(){return j(e.id)}}))):l.a.createElement("tr",{key:t},l.a.createElement("td",null,a?30*a+t+1-30:t+1,"."),l.a.createElement("td",null,e.dijak),l.a.createElement("td",null,l.a.createElement("select",{id:"",name:"",value:y.program?y.program:e.program,onChange:function(e){return x(Object(d.a)(Object(d.a)({},y),{},{program:e.target.value}))}},i&&i.program&&i.program.map((function(e){return l.a.createElement("option",{key:e.code,value:e.code},e.code)})))),l.a.createElement("td",null,l.a.createElement("input",{type:"text",value:y.naslov||""===y.naslov?y.naslov:e.naslov,onChange:function(e){return x(Object(d.a)(Object(d.a)({},y),{},{naslov:e.target.value?e.target.value:""}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"date",value:y.datum||""===y.datum?y.datum:(n=e.datum,E()(n,"DD.MM.yyyy").format("yyyy-MM-DD")),onChange:function(e){return x(Object(d.a)(Object(d.a)({},y),{},{datum:e.target.value?e.target.value:""}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",value:C||""===C?C:e.profesor,onChange:function(e){!function(e){S(e.target.value),""!==e.target.value?fetch("/rest/profesor/search",{method:"POST",headers:{"Content-Type":"text/html"},body:e.target.value}).then((function(e){return e.json()})).then((function(e){return P(e.strings)})):P(null)}(e)}}),T&&l.a.createElement(f,{results:T&&T,choosenElement:function(e){!function(e){S(e),P(null),x(Object(d.a)(Object(d.a)({},y),{},{profesor:e||""}))}(e)}})),l.a.createElement("td",null,l.a.createElement("select",{id:"",name:"",value:y.zavod?y.zavod:e.zavod,onChange:function(e){return x(Object(d.a)(Object(d.a)({},y),{},{zavod:e.target.value}))}},i&&i.zavod&&i.zavod.map((function(e){return l.a.createElement("option",{key:e.code,value:e.code},e.code)})))),l.a.createElement("td",null,l.a.createElement("select",{id:"",name:"",value:y.vrstaStudija?y.vrstaStudija:e.zavod,onChange:function(e){return x(Object(d.a)(Object(d.a)({},y),{},{vrstaStudija:e.target.value}))}},i&&i.vrstaStudija&&i.vrstaStudija.map((function(e){return l.a.createElement("option",{key:e.code,value:e.code},e.code)})))),l.a.createElement("td",null,!c&&h&&l.a.createElement("div",{className:"d-flex flex-column"},l.a.createElement("i",{className:"fas fa-check",onClick:function(){var t;t=e.id,fetch("/rest/diplomskaDela/saveDiplomskoDeloById",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(Object(d.a)(Object(d.a)({},y),{},{id:t}))}).then((function(){return u(s)})),j(!1)}}),l.a.createElement("i",{className:"fas fa-times",onClick:function(){return j(!1)}}))))})))),l.a.createElement(v,{numberOfPages:r,page:a,filtirajClick:function(e){return m(e)}}))}function h(e){var t=Object(n.useState)([]),a=Object(o.a)(t,2),r=a[0],c=a[1],i=Object(n.useState)(1),u=Object(o.a)(i,2),d=u[0],f=u[1],p=Object(n.useState)(),E=Object(o.a)(p,2),v=E[0],h=E[1],j=Object(n.useState)([]),g=Object(o.a)(j,2),O=g[0],y=g[1],x=Object(n.useState)([]),k=Object(o.a)(x,2),N=k[0],C=k[1],S=Object(n.useState)([]),w=Object(o.a)(S,2),D=w[0],T=w[1],P=Object(n.useState)([]),z=Object(o.a)(P,2),F=z[0],I=z[1],J=e.catalogue,U=J.program,L=J.zavod,M=J.vrstaStudija,B=J.profesor,H=Object(n.useState)(),R=Object(o.a)(H,2),A=R[0],Y=R[1],Z=e.leta,V=Object(n.useCallback)((function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:O,a=arguments.length>2&&void 0!==arguments[2]?arguments[2]:N,n=arguments.length>3&&void 0!==arguments[3]?arguments[3]:D,l=arguments.length>4&&void 0!==arguments[4]?arguments[4]:F;f(e),fetch("/rest/diplomskaDela/filter",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({programs:t,vrste:n,zavods:a,profesors:l,leto:A,page:e})}).then((function(e){return e.json()})).then((function(e){return c(e)})),fetch("/rest/diplomskaDela/count",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({programs:t,vrste:n,zavods:a,profesors:l,leto:A})}).then((function(e){return e.json()})).then((function(e){h(Math.ceil(e/30))}))}),[O,D,N,F,A]);return l.a.createElement(l.a.Fragment,null,l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"filter-element",style:{width:"10%"}},l.a.createElement("div",null,l.a.createElement("b",null,"Vrsta \u0161tudija"),l.a.createElement("div",null,M&&M.map((function(e,t){return l.a.createElement(m,{key:t,label:e.code,selected:!1,onChange:function(t){return function(e,t){var a=Object(s.a)(D);if(t)a.push(e),T(a);else{var n=a.indexOf(e);a.splice(n,1),T(a)}}(e.id,t)}})})))),l.a.createElement("div",null,l.a.createElement("b",null,"Program"),U&&U.map((function(e,t){return l.a.createElement(m,{key:t,label:e.code,selected:!1,name:e.vrsta,onChange:function(t){return function(e,t){var a=Object(s.a)(O);if(t)a.push(e),y(a);else{var n=a.indexOf(e);a.splice(n,1),y(a)}}(e.id,t)}})})),l.a.createElement("br",null)),l.a.createElement("div",null,l.a.createElement("b",null,"Zavod "),L&&L.map((function(e,t){return l.a.createElement(m,{key:t,label:e.code,selected:!1,onChange:function(t){return function(e,t){var a=Object(s.a)(N);if(t)a.push(e),C(a);else{var n=a.indexOf(e);a.splice(n,1),C(a)}}(e.id,t)}})})),l.a.createElement("br",null)),l.a.createElement("div",null,l.a.createElement("b",null,"Profesor "),l.a.createElement("div",{style:{maxHeight:"300px",overflowY:"scroll"}},B&&B.map((function(e,t){return l.a.createElement(m,{key:t,label:e.code,selected:!1,onChange:function(t){return function(e,t){var a=Object(s.a)(F);if(t)a.push(e),I(a);else{var n=a.indexOf(e);a.splice(n,1),I(a)}}(e.id,t)}})})),l.a.createElement("br",null))),l.a.createElement("div",null,l.a.createElement("div",null,l.a.createElement("b",null,"Leto")),l.a.createElement("label",{htmlFor:"letnice"}," Izberite leto: "),l.a.createElement("select",{id:"letnice",name:"letnice",value:null,onChange:function(e){return Y(""===e.target.value?null:e.target.value)}},l.a.createElement("option",{key:null,value:null},null),Z&&Z.map((function(e){return l.a.createElement("option",{key:e,value:e},e)}))),l.a.createElement("br",null),l.a.createElement("br",null)),l.a.createElement("div",{className:"d-flex flex-column"},l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){V(1)}},"Filtriraj"),l.a.createElement("button",{type:"button",className:"btn btn-primary d-flex flex-row align-items-center text-center",onClick:function(){return window.open("/servlet/DiplomskaDela","_blank")}},l.a.createElement("div",null,"Izvozi v PDF"),l.a.createElement("i",{className:"ml-3 fas fa-file-export"})))),l.a.createElement("div",{style:{width:"90%"}},l.a.createElement(b,{diplomskaDela:r&&r,page:d&&d,numberOfPages:v&&v,filtirajClick:function(e){return V(e)},readOnly:!0}))))}a(33),a(34);var j=Object(u.f)((function(e){e.catalogue.roles;var t=function(t){e.history.push(t)};return l.a.createElement("div",{style:{borderBottom:"1px solid black"},className:"d-flex flex-row justify-content-between align-items-center"},l.a.createElement("ul",null,l.a.createElement("li",{onClick:function(){return t("/admin/addChange")}},"Dodaj ali spremeni \u0161ifrante"),l.a.createElement("li",{onClick:function(){return t("/admin/addDiplomskoDelo")}},"Dodaj diplomsko delo"),l.a.createElement("li",{onClick:function(){return t("/admin/addUser")}},"Dodaj uporabnika")),l.a.createElement("div",null,l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){fetch("/servlet/logout",{method:"GET"}).then((function(){window.location.reload()}))}},"Logout")))}));function g(e){var t=e.catalogue;return l.a.createElement("div",null,l.a.createElement(j,{catalogue:t}))}function O(e){var t=e.value,a=e.title,r=e.label,c=e.twoInputs,i=e.reFetchCatalogue,u=Object(n.useState)(!1),s=Object(o.a)(u,2),m=s[0],d=s[1],f=Object(n.useState)(!1),p=Object(o.a)(f,2),E=p[0],v=p[1],b=Object(n.useState)(),h=Object(o.a)(b,2),j=h[0],g=h[1],O=Object(n.useState)(),y=Object(o.a)(O,2),x=y[0],k=y[1];return l.a.createElement("div",{style:{width:"300px"}},l.a.createElement("div",{className:"border border-dark"},l.a.createElement("div",{className:"border-bottom border-dark"},a,": "),l.a.createElement("div",null,t&&t.map((function(e,t){return l.a.createElement("div",{key:t,className:"d-flex flex-row justify-content-between"},l.a.createElement("div",null,e.code),l.a.createElement("i",{className:"fa fa-1x fa-trash "+(m===t?"text-primary":""),onMouseEnter:function(){return d(t)},onMouseLeave:function(){return d(null)},onClick:function(){return function(e){switch(r){case"program":fetch("/rest/program/remove",{method:"DELETE",headers:{"Content-Type":"application/json"},body:JSON.stringify({code:e})}).then((function(){return i()}));break;case"profesor":fetch("/rest/profesor/remove",{method:"DELETE",headers:{"Content-Type":"application/json"},body:JSON.stringify({imePriimek:e})}).then((function(){return i()}));break;case"vrstaStudija":fetch("/rest/vrstaStudija/remove",{method:"DELETE",headers:{"Content-Type":"application/json"},body:JSON.stringify({vrsta:e})}).then((function(){return i()}));break;case"zavod":fetch("/rest/zavod/remove",{method:"DELETE",headers:{"Content-Type":"application/json"},body:JSON.stringify({code:e})}).then((function(){return i()}))}}(e.code)}}))})),l.a.createElement("div",null,E?l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("i",{className:"fas fa-2x fa-times",onClick:function(){v(!1),g(null),k(null)}}),l.a.createElement("div",{className:"d-flex flex-row"},c?l.a.createElement("div",null,l.a.createElement("input",{className:"w-50",type:"text",placeholder:"del vpisne st",value:j||"",onChange:function(e){return g(e.target.value)}}),l.a.createElement("input",{className:"w-50",type:"text",placeholder:"ime",value:x||"",onChange:function(e){return k(e.target.value)}})):l.a.createElement("input",{className:"w-100",type:"text",placeholder:"ime in priimek",value:x||"",onChange:function(e){return k(e.target.value)}})),l.a.createElement("i",{className:"fas fa-2x fa-check",onClick:function(){v(!1),function(){switch(r){case"program":fetch("/rest/program/add",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({code:j,vrsta:x})}).then((function(e){return i()}));break;case"profesor":fetch("/rest/profesor/add",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({imePriimek:x})}).then((function(){return i()}));break;case"vrstaStudija":fetch("/rest/vrstaStudija/add",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({code:j,vrsta:x})}).then((function(){return i()}));break;case"zavod":fetch("/rest/zavod/add",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({zavod:x,code:j})}).then((function(){return i()}))}}(),g(null),k(null)}})):l.a.createElement("div",null,l.a.createElement("i",{className:"fas fa-2x fa-plus-circle",onClick:function(){return v(!0)}}))))))}function y(e){var t=e.catalogue,a=e.reFetchCatalogue,n=t.zavod,r=t.profesor,c=t.vrstaStudija,o=t.program;return l.a.createElement(l.a.Fragment,null,l.a.createElement(j,{catalogue:t}),l.a.createElement("div",{className:"d-flex flex-row justify-content-around pt-2"},l.a.createElement(O,{reFetchCatalogue:a(),twoInputs:!1,label:"profesor",value:r,title:"Profesor"}),l.a.createElement(O,{reFetchCatalogue:a(),twoInputs:!0,label:"program",value:o,title:"Program"}),l.a.createElement(O,{reFetchCatalogue:a(),twoInputs:!0,label:"zavod",value:n,title:"Zavod"}),l.a.createElement(O,{reFetchCatalogue:a(),twoInputs:!0,label:"vrstaStudija",value:c,title:"Vrsta studija"})))}function x(e){var t=e.catalogue,a=Object(n.useState)(null),r=Object(o.a)(a,2),c=r[0],i=r[1],u=Object(n.useState)(null),s=Object(o.a)(u,2),m=s[0],p=s[1],v=Object(n.useState)(null),h=Object(o.a)(v,2),g=h[0],O=h[1],y=Object(n.useState)(null),x=Object(o.a)(y,2),k=x[0],N=x[1],C=Object(n.useState)({}),S=Object(o.a)(C,2),w=S[0],D=S[1],T=Object(n.useState)(),P=Object(o.a)(T,2)[1],z=Object(n.useState)(),F=Object(o.a)(z,2),I=F[0],J=F[1],U=function(e){p(e),O(null),fetch("/rest/diplomskaDela/getDiplomskoDeloByIme",{method:"POST",headers:{"Content-Type":"text/html"},body:e}).then((function(e){return e.json()})).then((function(e){return N(e)}))};return l.a.createElement(l.a.Fragment,null,l.a.createElement(j,{catalogue:t}),l.a.createElement("div",null,l.a.createElement("div",{className:"text-primary"},"Spremeni diplomsko delo"),l.a.createElement("div",{className:"d-flex flex-row justify-content-between"},l.a.createElement("div",{style:{width:"203px"}},l.a.createElement("div",{className:"d-flex flex-column"},l.a.createElement("div",{className:"text-primary"},"I\u0161\u010di \u0161tudenta:"),l.a.createElement("input",{type:"text",value:m||"",onChange:function(e){!function(e){p(e.target.value),""!==e.target.value?(fetch("/rest/diplomskaDela/search",{method:"POST",headers:{"Content-Type":"text/html"},body:e.target.value}).then((function(e){return e.json()})).then((function(e){return O(e.strings)})),N(null)):(O(null),N(null))}(e)}}),g&&l.a.createElement(f,{results:g&&g,choosenElement:function(e){return U(e)}}))),l.a.createElement("div",{className:"w-75"},k&&l.a.createElement(b,{diplomskaDela:k,readOnly:!1,catalogue:t,reFetchDiplomskaDela:function(e){return U(e)},studentSearch:m}))),l.a.createElement("div",null,l.a.createElement("hr",null),l.a.createElement("div",null,l.a.createElement("div",{className:"text-primary"},"Dodaj diplomska dela"),l.a.createElement("div",null,l.a.createElement("form",null,l.a.createElement("input",{type:"file",id:"file",name:"file",onChange:function(e){return function(e){i(e.target.files[0])}(e)}}),l.a.createElement("button",{onClick:function(e){return function(e){e.preventDefault();var t=new FormData;t.append("file",c),fetch("/servlet/UploadExcelFileServlet",{method:"POST",body:t})}(e)}},"Submit")))),l.a.createElement("hr",null),l.a.createElement("div",null,l.a.createElement("div",{className:"text-primary"},"Dodaj diplomsko delo"),l.a.createElement("div",null,l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"text-primary"},"Vpisna \u0161tevilka:"),l.a.createElement("input",{type:"text",value:w.vpisnaStevilka||"",onChange:function(e){D(Object(d.a)(Object(d.a)({},w),{},{vpisnaStevilka:e.target.value}))}})),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"text-primary"},"Ime \u0161tudenta:"),l.a.createElement("input",{type:"text",value:w.imeDijaka||"",onChange:function(e){D(Object(d.a)(Object(d.a)({},w),{},{imeDijaka:e.target.value}))}})),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"text-primary"},"Naslov:"),l.a.createElement("input",{type:"text",value:w.imeDiplome||"",onChange:function(e){D(Object(d.a)(Object(d.a)({},w),{},{imeDiplome:e.target.value}))}})),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"text-primary"},"Datum:"),l.a.createElement("input",{type:"date",value:w.datumDiplome||"",onChange:function(e){D(Object(d.a)(Object(d.a)({},w),{},{datumDiplome:e.target.value}))}})),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",{className:"text-primary"},"Mentor:"),l.a.createElement("div",{className:"d-flex flex-column"},l.a.createElement("input",{type:"text",value:w.imeProf||"",onChange:function(e){!function(e){P(e.target.value),""!==e.target.value?fetch("/rest/profesor/search",{method:"POST",headers:{"Content-Type":"text/html"},body:e.target.value}).then((function(e){return e.json()})).then((function(e){return J(e.strings)})):J(null)}(e),D(Object(d.a)(Object(d.a)({},w),{},{imeProf:e.target.value}))}}),I&&l.a.createElement(f,{results:I&&I,choosenElement:function(e){!function(e){P(e),J(null),D(Object(d.a)(Object(d.a)({},w),{},{imeProf:e}))}(e)}}))),l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){!function(){var e,t=Object(d.a)(Object(d.a)({},w),{},{datumDiplome:(e=w.datumDiplome,E()(e).format("DD/MM/YYYY"))});fetch("/rest/diplomskaDela/addDiplomskoDelo",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(t)})}()}}," Shrani"))))))}var k=a(43);function N(e){var t=e.onCloseHandle,a=e.show,r=e.fetchUsers,c=Object(n.useState)({}),i=Object(o.a)(c,2),u=i[0],s=i[1];return l.a.createElement(k.a,{show:a},l.a.createElement("div",{style:{padding:"8px",backgroundColor:"#3e444a",color:"white"}},l.a.createElement("div",{className:"modalElement d-flex flex-column",style:{maxWidth:"300px",width:"300px"}},l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",null,"Username:"),l.a.createElement("input",{type:"text",value:u?u.username:"",onChange:function(e){return s(Object(d.a)(Object(d.a)({},u),{},{username:e.target.value}))}})),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",null,"Password:"),l.a.createElement("input",{type:"text",value:u?u.password:"",onChange:function(e){return s(Object(d.a)(Object(d.a)({},u),{},{password:e.target.value}))}}))),l.a.createElement("hr",null),l.a.createElement("div",{className:""},l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){t()}},"Zaklju\u010di"),l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){fetch("/rest/uporabnik/saveNewUser",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:u.username,password:u.password})}).then((function(){return r()})),t()}},"Shrani"))))}function C(e){var t=e.show,a=e.onCloseHandle,r=e.uporabnik,c=e.role,i=e.catalogue,u=e.reFetchRolesForUser,s=Object(n.useState)(),m=Object(o.a)(s,2),f=m[0],p=m[1],E=Object(n.useState)(!1),v=Object(o.a)(E,2),b=v[0],h=v[1],j=i.allRoles;Object(n.useEffect)((function(){r&&fetch("/rest/uporabnik/byUsername",{method:"POST",headers:{"Content-Type":"application/json"},body:r}).then((function(e){return e.json()})).then((function(e){return p(e)}))}),[r]);return l.a.createElement(k.a,{show:t},l.a.createElement("div",{style:{padding:"8px",backgroundColor:"#3e444a",color:"white"}},l.a.createElement("div",{className:"d-flex flex-column"},l.a.createElement("div",null,l.a.createElement("h1",null,r&&r)),l.a.createElement("hr",null),l.a.createElement("div",{className:"d-flex flex-row justify-content-between"},l.a.createElement("div",{className:"modalElement"},j&&j.map((function(e,t){var a=!1;return c&&c.map((function(t){return e===t&&(a=!0),null})),l.a.createElement("div",{key:t},a?l.a.createElement("div",{className:"d-flex flex-row align-items-center text-primary justify-content-between"},l.a.createElement("div",null,e),l.a.createElement("i",{className:"fas fa-lg fa-minus faminus ml-2",onClick:function(){return function(e){fetch("/rest/uporabnik/remove",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:r,role:e})}).then((function(e){return u(r)}))}(e)}})):l.a.createElement("div",{className:"d-flex flex-row align-items-center justify-content-between"},l.a.createElement("div",null,e),l.a.createElement("i",{className:"fas fa-lg fa-plus faplus",onClick:function(){return function(e){fetch("/rest/uporabnik/add",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:r,role:e})}).then((function(e){return u(r)}))}(e)}})))}))),l.a.createElement("div",{className:"modalElement d-flex flex-column",style:{maxWidth:"300px",width:"300px"}},l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",null,"Username:"),l.a.createElement("div",null,f&&f.username)),l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("div",null,"Password:"),b?l.a.createElement("input",{type:"text",value:f&&f.password,onChange:function(e){return p(Object(d.a)(Object(d.a)({},f),{},{password:e.target.value}))}}):l.a.createElement("div",null,f&&f.password)),b?l.a.createElement("div",null,l.a.createElement("button",{className:"btn btn-primary",onClick:function(){h(!1),fetch("/rest/uporabnik/saveByUsername",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({username:f.username,password:f.password})})}},"Shrani")):l.a.createElement("div",null,l.a.createElement("i",{className:"fas fa-edit iconOnHover",onClick:function(){return h(!0)}})))),l.a.createElement("hr",null),l.a.createElement("div",{className:""},l.a.createElement("button",{type:"button",className:"btn btn-primary",onClick:function(){a()}},"Zaklju\u010di")))))}function S(e){var t=e.catalogue,a=Object(n.useState)(),r=Object(o.a)(a,2),c=r[0],i=r[1],u=Object(n.useState)(),s=Object(o.a)(u,2),m=s[0],d=s[1],f=Object(n.useState)(),p=Object(o.a)(f,2),E=p[0],v=p[1],b=Object(n.useState)(!1),h=Object(o.a)(b,2),j=h[0],g=h[1],O=Object(n.useState)(!1),y=Object(o.a)(O,2),x=y[0],k=y[1],S=Object(n.useCallback)((function(){fetch("/rest/uporabnik/getAll").then((function(e){return e.json()})).then((function(e){return d(e)}))}),[]);Object(n.useEffect)((function(){S()}),[S]);var w=Object(n.useCallback)((function(e){fetch("/rest/catalogue/getAllRolesForUser",{method:"POST",headers:{"Content-Type":"application/json"},body:e}).then((function(e){return e.json()})).then((function(e){return v(e)}))}),[c]);return Object(n.useEffect)((function(){c&&fetch("/rest/catalogue/getAllRolesForUser",{method:"POST",headers:{"Content-Type":"application/json"},body:c}).then((function(e){return e.json()})).then((function(e){return v(e)}))}),[c]),l.a.createElement("div",{className:"d-flex flex-row justify-content-between"},l.a.createElement("div",{className:"d-flex flex-row"},l.a.createElement("table",{className:"table table-striped table-dark",style:{width:"150px"}},l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",null,"Uporabnik"))),l.a.createElement("tbody",null,m&&m.map((function(e,t){return l.a.createElement("tr",{className:c===e.username?"text-primary":"",key:t,onClick:function(){return i(e.username)}},l.a.createElement("td",{style:{padding:"12px"}},l.a.createElement("div",{className:"d-flex flex-row justify-content-between"},l.a.createElement("div",null,e.username),l.a.createElement("i",{className:"far fa-edit iconOnHover",onClick:function(){return g(!0)}}))))})))),l.a.createElement("table",{className:"table table-striped table-dark ml-5",style:{width:"150px"}},l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",null,"Vloga"))),l.a.createElement("tbody",null,E&&E.map((function(e,t){return l.a.createElement("tr",{key:t},l.a.createElement("td",null,e))}))))),l.a.createElement("div",{className:"addNewUser",onClick:function(){return k(!0)}},l.a.createElement("button",{type:"button",className:"btn btn-primary"},"Dodaj novega uporabnika")),j&&l.a.createElement(C,{show:j,onCloseHandle:function(){g(!1)},uporabnik:c,role:E,catalogue:t,reFetchRolesForUser:function(e){return w(e)}}),x&&l.a.createElement(N,{show:x,onCloseHandle:function(){k(!1)},fetchUsers:function(){return S()}}))}function w(e){var t=e.catalogue;return l.a.createElement("div",null,l.a.createElement(j,{catalogue:t}),l.a.createElement("div",null,l.a.createElement(S,{catalogue:t})))}var D=function(){var e=Object(n.useState)(),t=Object(o.a)(e,2),a=t[0],r=t[1],c=Object(n.useState)(),s=Object(o.a)(c,2),m=s[0],d=s[1],f=Object(n.useState)(),p=Object(o.a)(f,2),E=p[0],v=p[1],b=Object(n.useState)(),j=Object(o.a)(b,2),O=j[0],k=j[1],N=Object(n.useState)(),C=Object(o.a)(N,2),S=C[0],D=C[1],T=Object(n.useState)(),P=Object(o.a)(T,2),z=P[0],F=P[1];Object(n.useEffect)((function(){I(),fetch("/rest/zavod/getListOfIds").then((function(e){return e.json()})).then((function(e){k(e)})),fetch("/rest/program/getListOfIds").then((function(e){return e.json()})).then((function(e){d(e)})),fetch("/rest/vrstaStudija/getListOfIds").then((function(e){return e.json()})).then((function(e){v(e)})),fetch("/rest/profesor/getListOfIds").then((function(e){return e.json()})).then((function(e){D(e)})),fetch("/rest/diplomskaDela/leto").then((function(e){return e.json()})).then((function(e){F(e)}))}),[]);var I=function(){fetch("/rest/catalogue/getAll").then((function(e){return e.json()})).then((function(e){r(e)}))};return l.a.createElement(l.a.Fragment,null,a&&m&&E&&O&&S&&z&&l.a.createElement(i.a,null,l.a.createElement(u.c,null,l.a.createElement(u.a,{exact:!0,path:"/"},l.a.createElement(h,{catalogue:a,programIds:m,zavodIds:O,vrstaIds:E,profesorIds:S,leta:z})),l.a.createElement(u.a,{exact:!0,path:"/admin"},l.a.createElement(g,{catalogue:a})),l.a.createElement(u.a,{exact:!0,path:"/admin/addChange"},l.a.createElement(y,{catalogue:a,reFetchCatalogue:function(){return I}})),l.a.createElement(u.a,{exact:!0,path:"/admin/addDiplomskoDelo"},l.a.createElement(x,{catalogue:a})),l.a.createElement(u.a,{exact:!0,path:"/admin/addUser"},l.a.createElement(w,{catalogue:a})))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));c.a.render(l.a.createElement(D,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[26,1,2]]]);
//# sourceMappingURL=main.ec159fe4.chunk.js.map