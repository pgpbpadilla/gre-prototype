
var viewController = {
    model: Object.create(greTool),
    initialize: function() {
        this.model.delegate = this;
        this.buildMainContainer();
    },
    showFoundNodes: function(nodeList) {

        var resultsDiv, resultsTable, tr, td, model;

        resultsDiv = $('.results');

        resultsTable = this.buildResultsTable(nodeList);
        resultsTable.prop('class', 'results-table');
        
        resultsDiv.append(resultsTable);

        //set up events for the newly created results table
        model = this.model;
        $('.results td').click(function() {
            var curNode = JSON.parse($(this).text());
            model.selectConceptFromResult(curNode);
        });

        // show the results table
        resultsDiv.show();
    },
    showCurrentConcept: function(curNode) {
        $('.editor').text(curNode.content);
    },
    buildMainContainer: function() {

        // create workspace
        var appWorkspace = $('<div>');
        appWorkspace.prop('id', 'workspace');
        appWorkspace.addClass('workspace');
        // main content
        var mainContent = $('<div>');
        mainContent.prop('id', 'main-content');
        mainContent.addClass('main-content');
        // menu bar
        var menuBar = $('<div>');
        menuBar.prop('id', 'menu-bar');
        menuBar.addClass('menu-bar');
        var tagFinder = $('<div>');
        tagFinder.prop('tag-finder');
        tagFinder.addClass('tag-finder');
        tagFinder.append($('<input>'));
        // test input
        tagFinder.find('input').prop('placeholder', 'placeholder');
        tagFinder.find('input').val('text');

        menuBar.append(tagFinder); // append menu bar to workspace

        var optionsMenu = $('<div>');
        optionsMenu.prop('id', 'options-menu');
        optionsMenu.addClass('options-menu');
        optionsMenu.text('Options Menu');
        menuBar.append(optionsMenu);
        var leftBar = $('<div>');
        leftBar.prop('id', 'left-bar');
        leftBar.addClass('left-bar');
        leftBar.append($('<div>').text('CW'));
        var questionBar = $('<div>');
        questionBar.prop('id', 'current-question');
        questionBar.addClass('current-question');
        questionBar.text('Why did the chicken crossed the road..?');
        mainContent.append(questionBar); // append questionBar to mainContent
        // hide the question bar initially
        questionBar.hide();

        var editor = $('<div>');
        editor.prop('id', 'editor');
        editor.addClass('editor');
        editor.text('This will be the editor');
        mainContent.append(editor); // append the editor 

        var resultsDiv = $('<div>');
        resultsDiv.prop('id', 'results');
        resultsDiv.addClass('results');
        mainContent.append(resultsDiv);
        resultsDiv.hide();

        appWorkspace.append(menuBar);
        appWorkspace.append(leftBar);
        appWorkspace.append(mainContent);
        $('body').append(appWorkspace); // append the workspace to the page

        // setup events for search input
        var that = this;
        tagFinder.find('input').blur(function() {
            // use the model to find the nodes that match
            // the given criteria
            that.model.findNodes($(this).val());

        });
    },
    closeResults: function() {

        $('.results').empty().hide();

    },
    buildResultsTable: function(nodeList) {
        var tr, td, resultsTable;
        
        resultsTable= $('<table>');

        for (var i = 0; i < nodeList.length; ++i) {

            tr = $('<tr>');

            td = $('<td>');
            td.prop('class', 'result-node');
            td.text(JSON.stringify(nodeList[i]));

            tr.append(td);

            resultsTable.append(tr);
        }
        return resultsTable;
    }
};
