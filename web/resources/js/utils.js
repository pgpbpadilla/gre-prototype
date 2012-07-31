/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function setupView(){
    $('.node-info').click(function(){
        $(this).parent().find('input.search').click();
    });
}