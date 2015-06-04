<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tom Ready App __</title>
        <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
    </head>
    <body style="margin-top:10px;">
        <div class="container-fluid">
            <div class="row col-sm-12">
                <div class="row center-block">
                    <div class="jumbotron">
                        <h2 class="text-info">Hello, Templates</h2>
                        <img class="img-responsive img-rounded" src="banner.jpg"/>
                    </div>
                </div>
                <div class="row center-block">
                    <div class="col-sm-6">
                        <h3 class="text-info">Virtual Server</h3>
                        <dl class="dl-horizontal">
                            <dt>Hostname</dt>
                            <dd>${requestScope.solaris_info.host}</dd>
                            <dt>Virtualisation</dt>
                            <dd>${requestScope.solaris_info.container}</dd>
                            <dt>Version</dt>
                            <dd>${requestScope.solaris_info.version}</dd>                    
                        </dl>
                    </div>
                    <div class="col-sm-6">
                        <h3 class="text-info">WebLogic Server</h3>
                        <dl class="dl-horizontal">
                            <dt>Version</dt>
                            <dd>${requestScope.weblogic_info.version}</dd>
                            <dt>Server Name</dt>
                            <dd>${requestScope.weblogic_info.name}</dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
