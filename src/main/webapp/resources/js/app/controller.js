
function ViewController() {

    var that = this;

    var model = new GRETool();
    model.delegate = that;

    this.findNodes = function(textToSearch) {

        model.findNodes(textToSearch);

    };

    this.getNode = function(nodeId) {

        model.getNode(nodeId);
    };

    this.showFoundNodes = function(nodeList) {

        var resultsDiv = $('.results');

        var resultsTable = $('<table>');
        resultsTable.prop('class', 'results-table');

        for (var i = 0; i < nodeList.length; ++i) {

            var tr = $('<tr>');

            var td = $('<td>');
            td.prop('class', 'result-node');
            td.text(JSON.stringify(nodeList[i]));
            tr.append(td);

            resultsTable.append(tr);
        }

        resultsDiv.append(resultsTable);

        // events
        $('.results td').click(function() {
            var nodeId = JSON.parse($(this).text()).id;

            that.getNode(nodeId);

        });
        
        resultsDiv.show();
    };

    this.processData = function(data) {

        $('.editor').text(JSON.stringify(data));
    };

    this.loadTest = function() {

        var testParams = {
            test: '1'
        };
        var rm = new RequestManager();
        rm.callService(serviceNames.FindNodes, testParams, this.showFoundNodes);
    };

    this.buildMainContainer = function() {

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
        // events
        tagFinder.find('input').blur(function() {

            that.findNodes($(this).val());

        });
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

    };

    this.closeResults = function() {

        $('.results').hide();

    };
}
