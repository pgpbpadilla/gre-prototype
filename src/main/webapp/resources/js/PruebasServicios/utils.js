/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: Remove this file

function setupView(){
    $('.node-info').click(function(){
        $('.node-info').removeClass('selected');
        $(this).addClass('selected');
        $(this).parent().find('input[class*=load]').click();
    });
    
    $('.new').click(function(){
        $(this).parent().find('.edit-new').removeClass('hidden');
    });
    
}