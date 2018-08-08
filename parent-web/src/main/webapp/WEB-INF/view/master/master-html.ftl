<#global basePath=springMacroRequestContext.contextPath>
<#global jsRoot=springMacroRequestContext.contextPath +'/resources/js'>
<#global cssRoot=springMacroRequestContext.contextPath +'/resources/css'>
<#global imgRoot=springMacroRequestContext.contextPath +'/resources/image'>
<#global version="2016112411">
<#setting locale="en_US">

<#macro html>
<!DOCTYPE html>
<html lang="zh-cn">
    <#nested>
</html>

</#macro>

<#macro head title="" description="" keywords="">
<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,minimal-ui"
          name="viewport"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta http-equiv='Content-type' content='text/html; charset=utf-8'/>
    <meta name='format-detection' content='telephone=no'/>
        
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
    <link href='${cssRoot}/hightlight.default.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${cssRoot}/screen.css' media='screen' rel='stylesheet' type='text/css'/>
    <script src='${jsRoot}/swagger/jquery-1.8.0.min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/jquery.slideto.min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/jquery.wiggle.min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/jquery.ba-bbq.min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/handlebars-1.0.rc.1.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/underscore-min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/backbone-min.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/swagger.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/swagger-ui.js' type='text/javascript'></script>
    <script src='${jsRoot}/swagger/highlight.7.3.pack.js' type='text/javascript'></script>
     <style type="text/css">
        .swagger-ui-wrap {
            max-width: 960px;
            margin-left: auto;
            margin-right: auto;
        }

        .icon-btn {
            cursor: pointer;
        }

        #message-bar {
            min-height: 30px;
            text-align: center;
            padding-top: 10px;
        }

        .message-success {
            color: #89BF04;
        }

        .message-fail {
            color: #cc0000;
        }
    </style> 
    <script type="text/javascript">
        $(function () {
            window.swaggerUi = new SwaggerUi({
                discoveryUrl:"${basePath}/api-docs",
                apiKey:"",
                dom_id:"swagger-ui-container",
                supportHeaderParams: false,
                supportedSubmitMethods: ['get', 'post', 'put', 'delete'],
                onComplete: function(swaggerApi, swaggerUi){
                	if(console) {
                        console.log("Loaded SwaggerUI")
                        console.log(swaggerApi);
                        console.log(swaggerUi);
                    }
                  $('pre code').each(function(i, e) {hljs.highlightBlock(e)});
                },
                onFailure: function(data) {
                	if(console) {
                        console.log("Unable to Load SwaggerUI");
                        console.log(data);
                    }
                },
                docExpansion: "none"
            });

            window.swaggerUi.load();
        });

    </script>  
    <#nested>
</head>
</#macro>














