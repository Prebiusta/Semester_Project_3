#pragma checksum "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "5105bce317de1084b686dc75bbc1fef09f3adc6e"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Project_Index), @"mvc.1.0.view", @"/Views/Project/Index.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"5105bce317de1084b686dc75bbc1fef09f3adc6e", @"/Views/Project/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"095334c964c978378f687075dd67b876345a8e20", @"/Views/_ViewImports.cshtml")]
    public class Views_Project_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<Project>>
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
#line 3 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
  
    ViewData["Title"] = "Projects";

#line default
#line hidden
#nullable disable
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5105bce317de1084b686dc75bbc1fef09f3adc6e3571", async() => {
                WriteLiteral("\r\n    <title>Projects</title>\r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/custom.css\">\r\n\r\n");
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
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5105bce317de1084b686dc75bbc1fef09f3adc6e4648", async() => {
                WriteLiteral("\r\n<h1>Projects</h1>\r\n<div class=\"row\">\r\n    <div class=\"structure\">\r\n        <div class=\"create\">\r\n            <h3>Create New Project</h3>\r\n            <button id=\"create\" class=\"w3-button w3-xlarge w3-black w3-card-4\"");
                BeginWriteAttribute("onclick", " onclick=\"", 415, "\"", 469, 3);
                WriteAttributeValue("", 425, "location.href=\'", 425, 15, true);
#nullable restore
#line 17 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
WriteAttributeValue("", 440, Url.Action("CreateProject"), 440, 28, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 468, "\'", 468, 1, true);
                EndWriteAttribute();
                WriteLiteral(">+</button>\r\n        </div>\r\n");
#nullable restore
#line 19 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
         foreach (var item in Model) {

#line default
#line hidden
#nullable disable
                WriteLiteral("            <div class=\"project\">\r\n                <h1>");
#nullable restore
#line 21 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.name));

#line default
#line hidden
#nullable disable
                WriteLiteral("</h1>\r\n");
#nullable restore
#line 22 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
                 if(item.isAdministrator == true)
                {

#line default
#line hidden
#nullable disable
                WriteLiteral("                    <div class=\"admin\">Admin</div>\r\n");
#nullable restore
#line 25 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
                }

#line default
#line hidden
#nullable disable
                WriteLiteral("                <div class=\"buttonContainer\">\r\n                    <button class=\"example_c\"");
                BeginWriteAttribute("onclick", " onclick=\"", 874, "\"", 957, 3);
                WriteAttributeValue("", 884, "location.href=\'", 884, 15, true);
#nullable restore
#line 27 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
WriteAttributeValue("", 899, Url.Action("Index", "Sprint", new {id = item.projectId}), 899, 57, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 956, "\'", 956, 1, true);
                EndWriteAttribute();
                WriteLiteral(">Sprints</button>\r\n                    <button class=\"example_c\"");
                BeginWriteAttribute("onclick", " onclick=\"", 1022, "\"", 1108, 3);
                WriteAttributeValue("", 1032, "location.href=\'", 1032, 15, true);
#nullable restore
#line 28 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
WriteAttributeValue("", 1047, Url.Action("Index", "UserStory", new {id = item.projectId}), 1047, 60, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 1107, "\'", 1107, 1, true);
                EndWriteAttribute();
                WriteLiteral(@">Product Backlog</button>
                    <div class=""break""> </div>
                    <button class=""example_c"">Burndown Chart</button>
                    <button class=""example_c"">Edit Project</button>
                    <div class=""break""> </div>
                    <button class=""example_c""");
                BeginWriteAttribute("onclick", " onclick=\"", 1417, "\"", 1503, 5);
                WriteAttributeValue("", 1427, "location.href", 1427, 13, true);
                WriteAttributeValue(" ", 1440, "=", 1441, 2, true);
                WriteAttributeValue(" ", 1442, "\'", 1443, 2, true);
#nullable restore
#line 33 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
WriteAttributeValue("", 1444, Url.Action("Index", "Members", new {id = item.projectId}), 1444, 58, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 1502, "\'", 1502, 1, true);
                EndWriteAttribute();
                WriteLiteral(">Edit Members</button>\r\n                    <button class=\"example_c\">Leave Project</button>\r\n                </div>\r\n            </div>\r\n");
#nullable restore
#line 37 "C:\Users\VALERA\source\repos\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Index.cshtml"
        }

#line default
#line hidden
#nullable disable
                WriteLiteral("\r\n    </div>\r\n\r\n</div>\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<Project>> Html { get; private set; }
    }
}
#pragma warning restore 1591
