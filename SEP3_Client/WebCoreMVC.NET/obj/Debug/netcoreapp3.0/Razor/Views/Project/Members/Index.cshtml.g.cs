#pragma checksum "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "c448075797029bb0c6cdd3f103f00173beb2f202"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Project_Members_Index), @"mvc.1.0.view", @"/Views/Project/Members/Index.cshtml")]
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
#line 1 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\_ViewImports.cshtml"
using WebCoreMVC.NET.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"c448075797029bb0c6cdd3f103f00173beb2f202", @"/Views/Project/Members/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"095334c964c978378f687075dd67b876345a8e20", @"/Views/_ViewImports.cshtml")]
    public class Views_Project_Members_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<ContainerForListAndId<UserWithName>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("text-danger"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.ValidationSummaryTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_ValidationSummaryTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
  
    ViewData["Title"] = "Members";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<!DOCTYPE html>\r\n\r\n<html>\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c448075797029bb0c6cdd3f103f00173beb2f2024150", async() => {
                WriteLiteral("\r\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/custom.css\">\r\n        <title>Edit Members</title>\r\n");
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
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c448075797029bb0c6cdd3f103f00173beb2f2025231", async() => {
                WriteLiteral("\r\n    ");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("div", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "c448075797029bb0c6cdd3f103f00173beb2f2025493", async() => {
                }
                );
                __Microsoft_AspNetCore_Mvc_TagHelpers_ValidationSummaryTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.ValidationSummaryTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_ValidationSummaryTagHelper);
#nullable restore
#line 15 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
__Microsoft_AspNetCore_Mvc_TagHelpers_ValidationSummaryTagHelper.ValidationSummary = global::Microsoft.AspNetCore.Mvc.Rendering.ValidationSummary.ModelOnly;

#line default
#line hidden
#nullable disable
                __tagHelperExecutionContext.AddTagHelperAttribute("asp-validation-summary", __Microsoft_AspNetCore_Mvc_TagHelpers_ValidationSummaryTagHelper.ValidationSummary, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
                __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_0);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral(@"
    <h1>Members</h1>
    <div class=""row margin-left-80px"">
        <button class=""w3-button w3-black w3-card-4"" onclick=""goToPreviousWebsite()"">< Back</button>
        <br />
        <br />
        <button id=""addMember"" class=""w3-button w3-xlarge w3-black w3-card-4""");
                BeginWriteAttribute("onclick", " onclick=\"", 593, "\"", 683, 3);
                WriteAttributeValue("", 603, "location.href=\'", 603, 15, true);
#nullable restore
#line 21 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
WriteAttributeValue("", 618, Url.Action("AddMember", "Members", new {projectId = Model.id }), 618, 64, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 682, "\'", 682, 1, true);
                EndWriteAttribute();
                WriteLiteral(">+</button>\r\n        <ul>\r\n");
#nullable restore
#line 23 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
             foreach (var item in Model.accessList)
            {

#line default
#line hidden
#nullable disable
                WriteLiteral("                <li class=\"flex-row\">\r\n                    <p>- ");
#nullable restore
#line 26 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                    Write(item.username);

#line default
#line hidden
#nullable disable
                WriteLiteral("   ");
#nullable restore
#line 26 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                                     Write(item.firstName);

#line default
#line hidden
#nullable disable
                WriteLiteral(" ");
#nullable restore
#line 26 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                                                     Write(item.lastName);

#line default
#line hidden
#nullable disable
                WriteLiteral("</p>\r\n");
#nullable restore
#line 27 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                     if (!(@item.username.Equals(User.Identity.Name)))
                    {

#line default
#line hidden
#nullable disable
                WriteLiteral("                        <button class=\"deleteMemberButton w3-button w3-black w3-card-4\"");
                BeginWriteAttribute("onclick", " onclick=\"", 1078, "\"", 1186, 3);
                WriteAttributeValue("", 1088, "location.href=\'", 1088, 15, true);
#nullable restore
#line 29 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
WriteAttributeValue("", 1103, Url.Action("DeleteMember", "Members", new UserProject(@Model.id, @item.username)), 1103, 82, false);

#line default
#line hidden
#nullable disable
                WriteAttributeValue("", 1185, "\'", 1185, 1, true);
                EndWriteAttribute();
                WriteLiteral(">Delete member from the project</button>\r\n");
#nullable restore
#line 30 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"
                    }

#line default
#line hidden
#nullable disable
                WriteLiteral("                </li>\r\n");
#nullable restore
#line 32 "E:\szkoła\SEP3\Prebiusta\Semester_Project_3\SEP3_Client\WebCoreMVC.NET\Views\Project\Members\Index.cshtml"

            }

#line default
#line hidden
#nullable disable
                WriteLiteral("        </ul>\r\n    </div>\r\n");
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
            WriteLiteral("\r\n</html>");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<ContainerForListAndId<UserWithName>> Html { get; private set; }
    }
}
#pragma warning restore 1591