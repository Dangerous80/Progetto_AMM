/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//crea un elemento li che rappresenta un utente (contenuto in nrd)
function createElement(nrd){
    var link = $("<a>")
            .attr("href", "Bacheca?user="+nrd.id)
            .html(nrd.nome+" "+nrd.cognome);
    
    var img = $("<img>")
            .attr("class","fotoPersona")  
            .attr("alt","Foto Persona")
            .attr("src",nrd.urlFotoProfilo)
            .prependTo(link);
    
    return $("<li>")
            .append(link);
}  
function notElement(){
    var mess = $("<strong>")
            .html("Nessun Nerd Trovato");
        
    return $("<li>")
            .append(mess);
} 
function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    var userListPage = $("#usersList");
    $(userListPage).empty();
    $(userListPage).append(notElement());
}

$(document).ready(function(){
    $("#cerca").keyup(function(){
        
        var nerdCercato = $("#cerca")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                q: nerdCercato
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});
