<#import "/master/master-html.ftl" as html/>
<@html.html>
	<@html.head title="" description="" keywords=" ">
    </@html.head>
<body>    
<div id='header'>
    <div class="swagger-ui-wrap">
        <a id="logo" href="http://swagger.wordnik.com">swagger</a>

        <form id='api_selector'>
            <div class='input icon-btn'>
                <img id="show-pet-store-icon" src="${imgRoot}/swagger/pet_store_api.png" title="Show Swagger Petstore Example Apis">
            </div>
            <div class='input icon-btn'>
                <img id="show-wordnik-dev-icon" src="${imgRoot}/swagger/wordnik_api.png" title="Show Wordnik Developer Apis">
            </div>
            <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl"
                                      type="text"/></div>
            <div class='input'><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"/></div>
            <div class='input'><a id="explore" href="#">Explore</a></div>
        </form>
    </div>
</div>

<div id="message-bar" class="swagger-ui-wrap">
    &nbsp;
</div>

<div id="swagger-ui-container" class="swagger-ui-wrap">

</div>
</body>


</@html.html>
