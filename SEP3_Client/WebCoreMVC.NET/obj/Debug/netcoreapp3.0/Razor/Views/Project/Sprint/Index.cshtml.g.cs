#pragma checksum "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "7b066733fc018a52f5cb1e0d1a685b387dfbace3"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Project_Sprint_Index), @"mvc.1.0.view", @"/Views/Project/Sprint/Index.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"7b066733fc018a52f5cb1e0d1a685b387dfbace3", @"/Views/Project/Sprint/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"095334c964c978378f687075dd67b876345a8e20", @"/Views/_ViewImports.cshtml")]
    public class Views_Project_Sprint_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<Sprint>>
    {
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml"
  
    ViewData["Title"] = "Sprints";

#line default
#line hidden
#nullable disable
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "7b066733fc018a52f5cb1e0d1a685b387dfbace33611", async() => {
                WriteLiteral("\r\n    <title>Sprints</title>\r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/navbar.css\">\r\n\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "7b066733fc018a52f5cb1e0d1a685b387dfbace34687", async() => {
                WriteLiteral("\r\n<h1>Sprints</h1>\r\n<div class=\"row\">\r\n    <div class=\"structure\">\r\n        <div class=\"new_sprint\">\r\n            <h3>Plan Next Sprint</h3>\r\n            <button id=\"create\" class=\"w3-button w3-xlarge w3-black w3-card-4\"");
                BeginWriteAttribute("onclick", " onclick=\"", 413, "\"", 474, 3);
                WriteAttributeValue("", 423, "location.href=\'", 423, 15, true);
#nullable restore
#line 17 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml"
WriteAttributeValue("", 438, Url.Action("PlanSprint", "Sprint"), 438, 35, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 473, "\'", 473, 1, true);
                EndWriteAttribute();
                WriteLiteral(">+</button>\r\n        </div>\r\n\r\n");
#nullable restore
#line 20 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml"
         foreach (var item in Model) {

#line default
#line hidden
#nullable disable
                WriteLiteral("            <div class=\"sprint\">\r\n                <h1>Sprint ");
#nullable restore
#line 22 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml"
                      Write(Html.DisplayFor(modelItem => item.sprintNumber));

#line default
#line hidden
#nullable disable
                WriteLiteral(@"</h1>
                <div class=""buttonContainer"">
                    <button class=""example_c""> Sprint Backlog</button>
                    <button class=""example_c""> Tasks</button>
                    <div class=""break""> </div>
                    <button class=""example_c""> Burndown Chart</button>
                    <button class=""example_c""> Edit Sprint</button>
                    <div class=""break""> </div>
                    <button class=""example_c"">Edit Members</button>
                    <button class=""example_c"">Finish Sprint</button>
                </div>
            </div>
");
#nullable restore
#line 34 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Sprint\Index.cshtml"
        }

#line default
#line hidden
#nullable disable
                WriteLiteral("    </div>\r\n</div>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<Sprint>> Html { get; private set; }
    }
}
#pragma warning restore 1591