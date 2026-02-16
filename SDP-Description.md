<p>General Description</p>
<p>SDP Protocol Suite</p>
<p>Class Reference</p>
<p>Version 6.3</p>
<h1 class="TOC-Heading" id="section"><img src="media/image1.png"
style="width:1.48514in;height:0.7874in" /><br />
</h1>
<blockquote>
<p>First Edition: February 2005</p>
<p>Last Update: January 31<sup>st</sup>, 2023</p>
</blockquote>
<p>The information given in the documentation is subject to change
without notice and does not represent a commitment on the part of
MTS.</p>
<p>The software described in this document is provided under a license
agreement or non-disclosure agreement or another type of agreement. The
software may be used or copied only in accordance with the terms of the
relevant agreement. It is against the law to copy this software onto any
medium unless specifically allowed by the license or non-disclosure or
relevant agreement.</p>
<h1 id="table-of-contents">Table of Contents</h1>
<p>Table of Contents <a href="#table-of-contents">iii</a></p>
<p>About This Manual <a href="#about-this-manual">6</a></p>
<p>Terms and acronyms <a href="#terms-and-acronyms">6</a></p>
<p>Revision Change Summary <a href="#revision-change-summary">7</a></p>
<p>TradeImpact Infrastructure Overview <a
href="#tradeimpact-infrastructure-overview">11</a></p>
<p>TradeImpact Architecture <a
href="#tradeimpact-architecture">12</a></p>
<p>Modeling Markets Using Data Classes <a
href="#modeling-markets-using-data-classes">13</a></p>
<p>TradeImpact Services <a href="#tradeimpact-services">13</a></p>
<p>The SDP Protocol Suite <a href="#the-sdp-protocol-suite">17</a></p>
<p>The SDP Protocol Stack <a href="#the-sdp-protocol-stack">18</a></p>
<p>Client-Server Communication <a
href="#client-server-communication">20</a></p>
<p>Structure of SDP Messages <a
href="#structure-of-sdp-messages">21</a></p>
<p>Basic Data Types <a href="#basic-data-types">22</a></p>
<p>SSP Layer <a href="#ssp-layer">23</a></p>
<p>Blocking and Packing Protocol <a
href="#blocking-and-packing-protocol">24</a></p>
<p>Blocking and Packing <a href="#blocking-and-packing">24</a></p>
<p>Data Compression <a href="#data-compression">24</a></p>
<p>Block Header Format <a href="#block-header-format">24</a></p>
<p>Market Session Protocol (SSP) <a
href="#market-session-protocol-ssp">25</a></p>
<p>Opening an SSP Session and Negotiating its Characteristics <a
href="#opening-an-ssp-session-and-negotiating-its-characteristics">26</a></p>
<p>Changing the SSP Session Characteristics <a
href="#changing-the-ssp-session-characteristics">27</a></p>
<p>Exchanging Data in an SSP Session <a
href="#exchanging-data-in-an-ssp-session">28</a></p>
<p>Managing the Communication Window <a
href="#managing-the-communication-window">28</a></p>
<p>Alive Mechanism <a href="#alive-mechanism">28</a></p>
<p>Probe Mechanism <a href="#probe-mechanism">29</a></p>
<p>Closing an SSP Session <a href="#closing-an-ssp-session">29</a></p>
<p>SSP Server Automaton <a href="#ssp-server-automaton">30</a></p>
<p>SSP Client Automaton <a href="#ssp-client-automaton">31</a></p>
<p>SSP PDU Reference <a href="#ssp-pdu-reference">33</a></p>
<p>SSP PDU Common Header <a href="#ssp-pdu-common-header">34</a></p>
<p>SSP Session Open/Close PDUs <a
href="#ssp-session-openclose-pdus">34</a></p>
<p>SSPConOpenReq <a href="#sspconopenreq">34</a></p>
<p>SSPConOpenRes <a href="#sspconopenres">35</a></p>
<p>SSPConCloseReq <a href="#sspconclosereq">36</a></p>
<p>SSPConCloseRes <a href="#sspconcloseres">36</a></p>
<p>SSP Session Characteristics Modification PDUs <a
href="#ssp-session-characteristics-modification-pdus">37</a></p>
<p>SSPConModifyReq <a href="#sspconmodifyreq">37</a></p>
<p>SSPConModifyRes <a href="#sspconmodifyres">37</a></p>
<p>Data Exchange PDUs <a href="#data-exchange-pdus">37</a></p>
<p>SSPSendMsg <a href="#sspsendmsg">37</a></p>
<p>SSPSendMsgAck <a href="#sspsendmsgack">38</a></p>
<p>SSPSendData <a href="#sspsenddata">38</a></p>
<p>Session Alive Keep PDUs <a href="#session-alive-keep-pdus">38</a></p>
<p>SSPConAlive <a href="#sspconalive">38</a></p>
<p>Session Performance Probe PDUs <a
href="#session-performance-probe-pdus">39</a></p>
<p>SSPConProbeReq <a href="#sspconprobereq">39</a></p>
<p>SSPConProbeRes <a href="#sspconproberes">39</a></p>
<p>SSP Error Notification PDUs <a
href="#ssp-error-notification-pdus">39</a></p>
<p>SSPErrorMsg <a href="#ssperrormsg">39</a></p>
<p>SAP Layer <a href="#sap-layer">41</a></p>
<p>Managing the Logon/Logoff Sequence <a
href="#managing-the-logonlogoff-sequence">42</a></p>
<p>Modifying the Session Characteristics at Logon Time <a
href="#modifying-the-session-characteristics-at-logon-time">43</a></p>
<p>Retrieving IP addresses and TCP ports for services <a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">44</a></p>
<p>Changing a Trader’s Password <a
href="#changing-a-traders-password">45</a></p>
<p>Password Syntax and Validation Rules <a
href="#password-syntax-and-validation-rules">45</a></p>
<p>Executing Actions on a Class <a
href="#executing-actions-on-a-class">46</a></p>
<p>Submitting an Action Request <a
href="#submitting-an-action-request">47</a></p>
<p>Receiving the Response to an Action Request <a
href="#receiving-the-response-to-an-action-request">47</a></p>
<p>Managing a Sequence of Action Requests <a
href="#managing-a-sequence-of-action-requests">48</a></p>
<p>Managing Transactions <a href="#managing-transactions">49</a></p>
<p>Defining and Using Transaction IDs <a
href="#defining-and-using-transaction-ids">49</a></p>
<p>Managing Subscriptions <a href="#managing-subscriptions">49</a></p>
<p>Subscription Types <a href="#subscription-types">50</a></p>
<p>Subscription Filters <a href="#subscription-filters">51</a></p>
<p>Managing Queries <a href="#managing-queries">52</a></p>
<p>SAP Server Automaton <a href="#sap-server-automaton">53</a></p>
<p>SAP Client Automaton <a href="#sap-client-automaton">54</a></p>
<p>SAP PDU Reference <a href="#sap-pdu-reference">55</a></p>
<p>Transport Addresses Management PDUs <a
href="#transport-addresses-management-pdus">56</a></p>
<p>SAPAddressServiceReq <a href="#sapaddressservicereq">56</a></p>
<p>SAPAddressServiceRes <a href="#sapaddressserviceres">56</a></p>
<p>SAPAddressServiceReqExt <a href="#sapaddressservicereqext">57</a></p>
<p>SAPAddressServiceResExt <a href="#sapaddressserviceresext">57</a></p>
<p>Logon/Logoff PDUs <a href="#logonlogoff-pdus">59</a></p>
<p>SAPLogonReq <a href="#saplogonreq">59</a></p>
<p>SAPLogonRes <a href="#saplogonres">59</a></p>
<p>SAPLogonTokenReq <a href="#saplogontokenreq">61</a></p>
<p>SAPLogonTokenRes <a href="#saplogontokenres">62</a></p>
<p>SAPLogoffReq <a href="#saplogoffreq">63</a></p>
<p>SAPLogoffRes <a href="#saplogoffres">63</a></p>
<p>Password Management PDUs <a
href="#password-management-pdus">64</a></p>
<p>SAPChangePasswordReq <a href="#sapchangepasswordreq">64</a></p>
<p>SAPChangePasswordRes <a href="#sapchangepasswordres">64</a></p>
<p>Class Actions PDUs <a href="#class-actions-pdus">65</a></p>
<p>SAPExtActionReq <a href="#sapextactionreq">65</a></p>
<p>SAPExtActionRes <a href="#sapextactionres">66</a></p>
<p>SAPMonitoredActionReq <a href="#sapmonitoredactionreq">67</a></p>
<p>SAPMonitoredActionRes <a href="#sapmonitoredactionres">68</a></p>
<p>SAPActionReq <a href="#sapactionreq">69</a></p>
<p>SAPActionRes <a href="#sapactionres">69</a></p>
<p>SAP Error Notification PDUs <a
href="#sap-error-notification-pdus">71</a></p>
<p>SAPErrorMsg <a href="#saperrormsg">71</a></p>
<p>Subscription PDUs <a href="#subscription-pdus">72</a></p>
<p>SAPSubscribeStartReq <a href="#sapsubscribestartreq">72</a></p>
<p>SAPSubscribeStartRes <a href="#sapsubscribestartres">72</a></p>
<p>SAPSubscribeStopReq <a href="#sapsubscribestopreq">73</a></p>
<p>SAPSubscribeStopRes <a href="#sapsubscribestopres">73</a></p>
<p>SAPSubscribeData <a href="#sapsubscribedata">74</a></p>
<p>SAPSubscribeIdle <a href="#sapsubscribeidle">74</a></p>
<p>Filter Management PDUs <a href="#filter-management-pdus">75</a></p>
<p>SAPFilterCreateReq <a href="#sapfiltercreatereq">75</a></p>
<p>SAPFilterCreateRes <a href="#sapfiltercreateres">76</a></p>
<p>SAPFilterSetReq <a href="#sapfiltersetreq">76</a></p>
<p>SAPFilterSetRes <a href="#sapfiltersetres">76</a></p>
<p>SAPFilterDestroyReq <a href="#sapfilterdestroyreq">77</a></p>
<p>SAPFilterDestroyRes <a href="#sapfilterdestroyres">77</a></p>
<p>Query Management PDUs <a href="#query-management-pdus">78</a></p>
<p>SAPQueryReq <a href="#sapqueryreq">78</a></p>
<p>SAPQueryRes <a href="#sapqueryres">78</a></p>
<p>SAPQueryRowsDataReq <a href="#sapqueryrowsdatareq">79</a></p>
<p>SAPQueryRowsDataRes <a href="#sapqueryrowsdatares">79</a></p>
<p>SAPQueryRowsData <a href="#sapqueryrowsdata">80</a></p>
<p>SAPQueryRowsEnd <a href="#sapqueryrowsend">80</a></p>
<p>SAPQueryDestroyReq <a href="#sapquerydestroyreq">80</a></p>
<p>SAPQueryDestroyRes <a href="#sapquerydestroyres">81</a></p>
<p>SMP Layer <a href="#smp-layer">83</a></p>
<p>SMP Class Hierarchy <a href="#smp-class-hierarchy">84</a></p>
<p>Summary of MTS Classes <a href="#summary-of-mts-classes">84</a></p>
<p>SMP Conventions <a href="#smp-conventions">85</a></p>
<p>Putting Everything Together <a
href="#putting-everything-together">87</a></p>
<p>Retrieving TCP/IP Addresses and Opening Transport Connections <a
href="#retrieving-tcpip-addresses-and-opening-transport-connections">88</a></p>
<p>Establishing SSP Sessions <a
href="#establishing-ssp-sessions">89</a></p>
<p>Managing the Trader's Logon <a
href="#managing-the-traders-logon">90</a></p>
<p>Operating on Classes <a href="#operating-on-classes-1">91</a></p>
<p>Starting and Managing Subscriptions <a
href="#starting-and-managing-subscriptions">91</a></p>
<p>Executing Actions on a Class (Transactional Services Only) <a
href="#executing-actions-on-a-class-transactional-services-only">92</a></p>
<p>Technical Notes <a href="#technical-notes">95</a></p>
<p>SSL Implementation <a href="#ssl-implementation">96</a></p>
<p>Data Compression Algorithm <a
href="#data-compression-algorithm">96</a></p>
<p>XDR Coding <a href="#xdr-coding">96</a></p>
<p>Request-Response Timeout <a
href="#request-response-timeout">96</a></p>
<h1 id="about-this-manual">About This Manual</h1>
<p>This manual provides an overview of the multi-layer SDP protocol
suite and the services provided by each of its layers. The SDP interface
defines the concepts and general rules that client systems must comply
with in order to access the services made available by TradeImpact, the
new Technology infrastructure for on-line trading of financial products
on the electronic markets.</p>
<p>This document provides:</p>
<ul>
<li><p>An overview of the SDP protocol suite.</p></li>
<li><p>A full description of the SSP layer, including general concepts,
protocol rules, SSP PDUs reference and Security Socket Layer (SSL)
handshaking. SSL is mandatory for client applications accessing the SDP
services by Internet.</p></li>
<li><p>A full description of the SAP layer, including general concepts,
protocol rules and SAP PDUs reference.</p></li>
<li><p>A description of the SMP layer, including general concepts and
protocol rules.</p></li>
<li><p>An example of use of the protocols in the SDP suite.</p></li>
<li><p>Relevant technical aspects (for example, compression algorithm
and XDR coding)</p></li>
</ul>
<h2 id="terms-and-acronyms">Terms and acronyms</h2>
<table style="width:99%;">
<colgroup>
<col style="width: 31%" />
<col style="width: 67%" />
</colgroup>
<thead>
<tr>
<th style="text-align: left;">Term</th>
<th style="text-align: left;">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: left;">IP SP – single platform</td>
<td style="text-align: left;">IP Service Provider specific to each
platform</td>
</tr>
<tr>
<td style="text-align: left;">IP SP – centralized</td>
<td style="text-align: left;">IP Service Provider centralized and unique
for all platforms</td>
</tr>
<tr>
<td style="text-align: left;">MTS_BV (Identifier 6)</td>
<td style="text-align: left;">BondVision Platform [BV Market]</td>
</tr>
<tr>
<td style="text-align: left;">MTS_CMF (Identifier 3)</td>
<td style="text-align: left;">CMF Platform [Cash Market Facility
Market]</td>
</tr>
<tr>
<td style="text-align: left;">MTS_MMF2 (Identifier 4)</td>
<td style="text-align: left;">MMF Platform [Repo Trading Facility and
Swap Market Facility Markets]</td>
</tr>
<tr>
<td style="text-align: left;">MTS_PAF (Identifier 2)</td>
<td style="text-align: left;">PAF Platform [Primary Auction Market]</td>
</tr>
<tr>
<td style="text-align: left;">MTS_STF (Identifier 5)</td>
<td style="text-align: left;">STF Platform [Swap Trading Facility
Market]</td>
</tr>
<tr>
<td style="text-align: left;">TradeImpact</td>
<td style="text-align: left;">Technology infrastructure for on-line
trading of financial products on the electronic markets</td>
</tr>
</tbody>
</table>
<h2 id="revision-change-summary"><br />
Revision Change Summary</h2>
<table style="width:97%;">
<colgroup>
<col style="width: 33%" />
<col style="width: 0%" />
<col style="width: 63%" />
</colgroup>
<thead>
<tr>
<th colspan="2" style="text-align: left;">AFFECTED ITEM</th>
<th style="text-align: left;">CHANGE DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
6.2 to version 6.3 of this document</strong></td>
</tr>
<tr>
<td style="text-align: left;">All document</td>
<td colspan="2" style="text-align: left;">Rebrending Euronext</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
6.1 to version 6.2 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#the-sap-layer">The SAP Layer</a>” on page <a
href="#the-sap-layer">18</a></p>
<p>“<a href="#managing-subscriptions">Managing Subscriptions</a>” on
page <a href="#managing-subscriptions">51</a></p>
<p>“<a href="#sapsubscribestartreq">SAPSubscribeStartReq</a>” on page <a
href="#sapsubscribestartreq">74</a></p>
<p>“<a href="#sapsubscribestartres">SAPSubscribeStartRes</a>” on page <a
href="#sapsubscribestartres">74</a></p>
<p>“<a href="#putting-everything-together">Putting Everything
Together</a>” - “<a href="#operating-on-classes-1">Operating on
Classes</a>” - “<a href="#starting-and-managing-subscriptions">Starting
and Managing Subscriptions</a>” on page <a
href="#starting-and-managing-subscriptions">93</a></p></td>
<td style="text-align: left;"><p>The subscription mask is no longer
used.</p>
<p>As a consequence:</p>
<ul>
<li><p>Reference to the subscription mask has been removed from the
general description of the SAP layer and from the general description of
Subscription management.</p></li>
<li><p>Subchapter “Subscription Mask” has been removed from chapter
“Managing Subscriptions”.</p></li>
<li><p>In PDU SAPSubscribeStartReq , field SubMask has been
removed</p></li>
<li><p>In PDU SAPSubscribeStartRes, field “Result”, error “4 –
SAP_SubscribeInvalidSubMask” has been replaced with “4 – Reserved for
future use”</p></li>
<li><p>Reference to the subscription mask has been removed from the
general description “Starting and Managing Subscriptions”</p></li>
</ul></td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
6.0 to version 6.1 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#managing-transactions">Managing Transactions</a>” on page <a
href="#managing-transactions">51</a></p>
<p>“<a href="#sap-pdu-reference">SAP PDU Reference</a>” on page <a
href="#sap-pdu-reference">57</a></p>
<p>“<a href="#sap-server-automaton">SAP Server Automaton</a>” on page <a
href="#sap-server-automaton">55</a></p>
<p>“<a href="#sap-client-automaton">SAP Client Automaton</a>” on page <a
href="#sap-client-automaton">56</a></p></td>
<td style="text-align: left;"><p>SAP PDUs:</p>
<ul>
<li><p>SAPTransactionStatusReq</p></li>
<li><p>SAPTRansactionStatusRes</p></li>
</ul>
<p>are no longer used.</p>
<p>As a consequence:</p>
<ul>
<li><p>Subchapter “Requesting the Status of a Trasaction” has been
removed from chapter “Managing Transactions”.</p></li>
<li><p>Subchapter “Transaction Status PDUs” has been removed from
chapter “SAP PDU Reference”</p></li>
<li><p>References to SAPTransactionStatusReq, SAPTransactionStatusRes
have been removed from SAP Server/client Automaton</p></li>
</ul></td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
5.1 to version 6.0 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"></td>
<td style="text-align: left;"><p>Services and functionalities introduced
with project “TradeImpact MTS Platform Segmentation” are available to
CMF:</p>
<ul>
<li><p>Services TXN, DATAFEED, QUERY</p></li>
<li><p>Single centralized IP Service Provider</p></li>
<li><p>Single sign-on authentication process</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>” on page <a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">15</a></td>
<td style="text-align: left;"><p>Tables listing IP SP access modes and
TradeImpact services have been updated for the CMF platform:</p>
<ul>
<li><p>IP SP mode is “centralized”</p></li>
<li><p>Services TXN, QUERY, DATAFEED are available</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#managing-the-logonlogoff-sequence">Managing the Logon/Logoff
Sequence</a>” on page <a
href="#managing-the-logonlogoff-sequence">44</a></td>
<td style="text-align: left;"><p>The table listing the Logon
authentication mode has been updated for the CMF platform:</p>
<ul>
<li><p>Single sign-on is available to CMF.</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">Retrieving IP
addresses and TCP ports for services</a>” on page <a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">46</a></td>
<td style="text-align: left;"><p>The table listing “Sap AddressService”
PDU types has been updated for the CMF platform:</p>
<ul>
<li><p>SAPAddressServiceReqExt/ SAPAddressServiceResExt are available to
CMF.</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#sapaddressserviceresext">SAPAddressServiceResExt</a>” on page <a
href="#sapaddressserviceresext">59</a></p>
<p>“<a href="#saplogonreq">SAPLogonReq</a>” on page <a
href="#saplogonreq">61</a></p>
<p>“<a href="#saplogontokenreq">SAPLogonTokenReq</a>” on page <a
href="#saplogontokenreq">63</a></p></td>
<td style="text-align: left;"><p>The Notes highlighting services
provided by TradeImpact have been modified:</p>
<ul>
<li><p>Service TXN is implemented on CMF.</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#executing-actions-on-a-class">Executing Actions on a Class</a>”
on page <a href="#executing-actions-on-a-class">48</a></p>
<p>“<a href="#class-actions-pdus">Class Actions PDUs</a>” on page <a
href="#class-actions-pdus">67</a></p>
<p>“<a
href="#executing-actions-on-a-class-transactional-services-only">Executing
Actions on a Class (Transactional Services Only)</a>” on page <a
href="#executing-actions-on-a-class-transactional-services-only">94</a></p></td>
<td style="text-align: left;"><p>Description of SAP PDUs used to perform
Actions has been modified, to underline suggested usage of PDUs
SAPExtActionRes/Req (in place of SAPMonitoredActionRes/Req,
SAPActionRes/Req).</p>
<p>Paragraphs describing SAPExtActionRes/Req,</p>
<p>SAPMonitoredActionReq/Res, SAPActionReq/Res have been grouped in a
new chapter.</p></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#subscription-pdus">Subscription PDUs</a>” on page <a
href="#subscription-pdus">74</a></td>
<td style="text-align: left;">PDU SAPSubscribeResetData has been
removed.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
5.0 to version 5.1 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>” on page <a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">15</a></td>
<td style="text-align: left;">Services QUERY, DATAFEED are available to
REPO and SWAP markets (MMF Platform)</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
4.2 to version 5.0 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>” on page <a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">15</a></p>
<p>“<a href="#managing-the-logonlogoff-sequence">Managing the
Logon/Logoff Sequence</a>” on page <a
href="#managing-the-logonlogoff-sequence">44</a></p>
<p>“<a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">Retrieving IP
addresses and TCP ports for services</a>” on page <a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">46</a></p></td>
<td style="text-align: left;">IP SP centralized service, and single
sign-on, are available to REPO and SWAP markets (MMF Platform)</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#block-header-format">Block Header Format</a>” on page <a
href="#block-header-format">24</a></td>
<td style="text-align: left;">A note on BlockNumber sequence has been
added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
4.1 to version 4.2 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#sspconopenreq">SSPConOpenReq</a>” on page <a
href="#sspconopenreq">34</a></p>
<p>“<a href="#sspconopenres">SSPConOpenRes</a>” on page <a
href="#sspconopenres">35</a></p></td>
<td style="text-align: left;"><p>In SSP Session Open/Close PDUs:</p>
<ul>
<li><p>Field ProtocolVersion is reserved for future use.</p></li>
</ul></td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
4.0 to version 4.1 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#tradeimpact-architecture">TradeImpact Architecture</a>” on page
<a href="#tradeimpact-architecture">12</a></td>
<td style="text-align: left;">In the picture showing connections to
Trade Impact, only “Internet” and “Leased Line” are highlighted.
Previous “SIA-net” and “Private net” have been replaced by “Leased
Line”.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#tradeimpact-services">TradeImpact Services</a>” on page <a
href="#tradeimpact-services">13</a></td>
<td style="text-align: left;">Clarifications about the availability of
services on the various MTS platforms has been added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#sapaddressserviceresext">SAPAddressServiceResExt</a>” on page <a
href="#sapaddressserviceresext">59</a></p>
<p>“<a href="#saplogonreq">SAPLogonReq</a>” on page <a
href="#saplogonreq">61</a></p>
<p>“<a href="#saplogontokenreq">SAPLogonTokenReq</a>” on page <a
href="#saplogontokenreq">63</a></p></td>
<td style="text-align: left;">The list of available services, depending
on the IP service mode, has been updated.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
3.1 to version 4.0 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#terms-and-acronyms">Terms and acronyms</a>” on page <a
href="#terms-and-acronyms">5</a></td>
<td style="text-align: left;">The “Terms and Acronyms” table has been
added</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"></td>
<td style="text-align: left;"><p>In the “TradeImpact MTS Platform
Segmentation” project context the following functionalities have been
added:</p>
<ul>
<li><p>New services, i.e.TXN, DATAFEED, QUERY</p></li>
<li><p>Single centralized IP Service Provider</p></li>
<li><p>Single sign-on authentication process</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#tradeimpact-services">TradeImpact Services</a>” on page <a
href="#tradeimpact-services">13</a></td>
<td style="text-align: left;"><p>Services:</p>
<ul>
<li><p>TXN</p></li>
<li><p>DATAFEED</p></li>
<li><p>QUERY</p></li>
</ul>
<p>have been added.</p>
<p>Description of service</p>
<ul>
<li><p>TXN_INFO_PRIV</p></li>
</ul>
<p>has been modified (as a consequence of the introduction of the TXN
service).</p>
<p>Description of service</p>
<ul>
<li><p>IP Provider Service (IP_REQUEST)</p></li>
</ul>
<p>has been modified (as a consequence of the introduction of the single
centralized IP Service Provider)</p></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#the-sdp-protocol-stack">The SDP Protocol Stack</a>” - “<a
href="#the-sap-layer">The SAP Layer</a>” on page <a
href="#the-sap-layer">18</a></td>
<td style="text-align: left;">Reference to the IP SP service has been
added</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a href="#sap-layer">SAP
Layer</a>” - “<a href="#managing-the-logonlogoff-sequence">Managing the
Logon/Logoff Sequence</a>” on page <a
href="#managing-the-logonlogoff-sequence">44</a></td>
<td style="text-align: left;">Specifications of Logon for the single
sign-on procedure have been added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a href="#sap-layer">SAP
Layer</a>” - “<a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">Retrieving IP
addresses and TCP ports for services</a>” on page <a
href="#retrieving-ip-addresses-and-tcp-ports-for-services">46</a></td>
<td style="text-align: left;">A new chapter has been added, to introduce
the new SAP PDUs used to retrieve IP address and TCP ports assigned to
services</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"><p>“<a
href="#sap-pdu-reference">SAP PDU Reference</a>” – “<a
href="#transport-addresses-management-pdus">Transport Addresses
Management PDUs</a>” -</p>
<p>“<a href="#sapextactionreq">SAPExtActionReq</a>” on page <a
href="#sapextactionreq">67</a></p>
<p>“<a href="#sapextactionres">SAPExtActionRes</a>” on page <a
href="#sapextactionres">68</a></p></td>
<td style="text-align: left;"><p>Two SAP PDUs of type “Address Service”
have been added:</p>
<ul>
<li><p>SAPAddressServiceReqExt</p></li>
<li><p>SAPAddressServiceResExt</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sap-pdu-reference">SAP PDU Reference</a>” – “<a
href="#logonlogoff-pdus">Logon/Logoff PDUs</a>” on page <a
href="#logonlogoff-pdus">61</a></td>
<td style="text-align: left;"><p>Notes detailing the services provided
by TradeImpact on the various platform types have been added to:</p>
<ul>
<li><p>SAPLogonReq</p></li>
<li><p>SAPLogonTokenReq</p></li>
</ul></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#putting-everything-together">Putting Everything Together</a>” -
“<a
href="#retrieving-tcpip-addresses-and-opening-transport-connections">Retrieving
TCP/IP Addresses and Opening Transport Connections</a>” on page <a
href="#retrieving-tcpip-addresses-and-opening-transport-connections">90</a></td>
<td style="text-align: left;">Clarifications about PDUs to be used ,
depending on the mode used to retrieve addresses of services, have been
added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#putting-everything-together">Putting Everything Together</a>” -
“<a href="#managing-the-traders-logon">Managing the Trader's Logon</a>”
on page <a href="#managing-the-traders-logon">92</a></td>
<td style="text-align: left;">Clarifications about trader’s
authentication have been added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
3.0 to version 3.1 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#basic-data-types">Basic Data Types</a>” on page <a
href="#basic-data-types">22</a></td>
<td style="text-align: left;"><p><strong><span class="smallcaps">Errata
Corrige</span></strong></p>
<p>TimeStamp formats have been changed.</p></td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
2.0 to version 3.0 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#basic-data-types">Basic Data Types</a>” on page <a
href="#basic-data-types">22</a></td>
<td style="text-align: left;">The <strong>UTIME</strong> data type has
been added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sap-server-automaton"><br />
SAP Server Automaton</a>” on page and “<a
href="#sap-client-automaton">SAP Client Automaton</a>” on page</td>
<td style="text-align: left;">SAP automata have been updated to
accomodate the <strong>SAPExtActionReq</strong> and
<strong>SAPExtActionRes</strong> PDU's.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapextactionreq">SAPExtActionReq</a>” on page <a
href="#sapextactionreq">67</a></td>
<td style="text-align: left;">The <strong>SAPExtActionReq</strong> and
<strong>SAPExtActionRes</strong> PDUs, providing timestamps with
microsecond resolution, have been added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.13 to version 2.0 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconprobereq">SSPConProbeReq</a>” on page <a
href="#sspconprobereq">40</a></td>
<td style="text-align: left;"><p>The PDU description has been
changed.</p>
<p>The ProbeData field type has been changed.</p></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconproberes">SSPConProbeRes</a>” on page <a
href="#sspconproberes">40</a></td>
<td style="text-align: left;"><p>The PDU description has been
changed.</p>
<p>The ProbeData field type and description have been changed.</p></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#saplogontokenreq">SAPLogonTokenReq</a>” on page <a
href="#saplogontokenreq">63</a></td>
<td style="text-align: left;">The SAPLogonTokenReq PDU has been
added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#saplogontokenres">SAPLogonTokenRes</a>” on page <a
href="#saplogontokenres">64</a></td>
<td style="text-align: left;">The SAPLogonTokenRes PDU has been
added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.12 to version 1.13 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapfiltercreatereq">SAPFilterCreateReq</a>” on page <a
href="#sapfiltercreatereq">77</a></td>
<td style="text-align: left;">The FilterVal field type and description
have been changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapfiltersetreq">SAPFilterSetReq</a>” on page <a
href="#sapfiltersetreq">78</a></td>
<td style="text-align: left;">The FilterVal field type and description
have been changed.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.11 to version 1.12 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapsubscribestartres">SAPSubscribeStartRes</a>” on page <a
href="#sapsubscribestartres">74</a></td>
<td style="text-align: left;">A new Result value has been added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.10 to version 1.11 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;"></td>
<td style="text-align: left;">Introduction of Security Socket Layer
(SSL)</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.9 to version 1.10 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapsubscribestartres">SAPSubscribeStartRes</a>” on page <a
href="#sapsubscribestartres">74</a></td>
<td style="text-align: left;">A new Result value has been added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.8 to version 1.9 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#block-header-format">Block Header Format</a>” on page <a
href="#block-header-format">24</a></td>
<td style="text-align: left;">The BlockLen field type and description
have been changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenreq">SSPConOpenReq</a>” on page <a
href="#sspconopenreq">34</a></td>
<td style="text-align: left;">The MaxBlkLenRequired field type and
description have been changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenres">SSPConOpenRes</a>” on page <a
href="#sspconopenres">35</a></td>
<td style="text-align: left;">The MaxBlkLenRes field type and
description have been changed.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.7 to version 1.8 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#block-header-format">Block Header Format</a>” on page <a
href="#block-header-format">24</a></td>
<td style="text-align: left;">The BlockLen field type has been
changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenreq">SSPConOpenReq</a>” on page <a
href="#sspconopenreq">34</a></td>
<td style="text-align: left;">The MaxBlkLenRequired field type has been
changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenres">SSPConOpenRes</a>” on page <a
href="#sspconopenres">35</a></td>
<td style="text-align: left;">The MaxBlkLenRes field type has been
changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#ssperrormsg">SSPErrorMsg</a>” on page <a
href="#ssperrormsg">41</a></td>
<td style="text-align: left;">A new ErrorCode has been added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapqueryres">SAPQueryRes</a>” on page <a
href="#sapqueryres">80</a></td>
<td style="text-align: left;">A new Result value has been added.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapqueryrowsdatares">SAPQueryRowsDataRes</a>” on page <a
href="#sapqueryrowsdatares">81</a></td>
<td style="text-align: left;">A new Result value has been added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.6 to version 1.7 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenreq">SSPConOpenReq</a>” on page <a
href="#sspconopenreq">34</a></td>
<td style="text-align: left;">The MaxBlkLenRequired field description
has been changed.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sspconopenres">SSPConOpenRes</a>” on page <a
href="#sspconopenres">35</a></td>
<td style="text-align: left;">The MaxBlkLenRes field description has
been changed.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.5 to version 1.6 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#saplogonres">SAPLogonRes</a>” on page <a
href="#saplogonres">62</a></td>
<td style="text-align: left;">14, 15 and 16 Result values have been
added.</td>
</tr>
<tr>
<td colspan="3" style="text-align: left;"><strong>Changes from version
1.4 to version 1.5 of this document</strong></td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sap-server-automaton"><br />
SAP Server Automaton</a>” on page and “<a
href="#sap-client-automaton">SAP Client Automaton</a>” on page</td>
<td style="text-align: left;">SAP automata have been updated to
accomodate the <strong>SAPMonitoredActionReq</strong> and
<strong>SAPMonitoredActionRes</strong> PDU's.</td>
</tr>
<tr>
<td colspan="2" style="text-align: left;">“<a
href="#sapmonitoredactionreq">SAPMonitoredActionReq</a>” on page <a
href="#sapmonitoredactionreq">69</a></td>
<td style="text-align: left;">The <strong>SAPMonitoredActionReq</strong>
and <strong>SAPMonitoredActionRes</strong> PDUs have been added.</td>
</tr>
</tbody>
</table>
<h1 id="section-1"></h1>
<h1 id="tradeimpact-infrastructure-overview">TradeImpact Infrastructure
Overview</h1>
<blockquote>
<p>TradeImpact is the new electronic infrastructure for on-line trading
of financial products on the electronic markets. It has been
specifically designed to provide users with the following main
advantages:</p>
</blockquote>
<ul>
<li><p>Management of large data volumes and transaction peaks</p></li>
<li><p>Capability of integrating trading platforms from other
vendors</p></li>
<li><p>Direct access by the client systems to the server environment,
using any of the communication protocols supported</p></li>
</ul>
<h2 id="tradeimpact-architecture">TradeImpact Architecture</h2>
<blockquote>
<p>shows the architecture of the TradeImpact platform.</p>
</blockquote>
<figure>
<img src="media/image2.png" style="width:3.92708in;height:3.14167in" />
<figcaption><blockquote>
<p><strong>Figure 1.</strong> TradeImpact Architecture</p>
</blockquote></figcaption>
</figure>
<h6 id="the-server-environment">The Server Environment</h6>
<blockquote>
<p>The systems in the server environment ensure the consistency and
integrity of market data.</p>
<p>They manage and make available to the members the global market data
(about products, members, etc.), fulfill the requests from the traders,
calculate and distribute statistical and summary data about the markets,
interface external bodies (for example, press agencies) and the
automatic clearing systems.</p>
<p>The application functions are centralized and executed on the server
environment, where there is a clear distinction between back-end
systems, on which transactions are processed, and front-end systems,
dedicated to managing connections with the client systems.</p>
<p>On the server environment, back-end and front-end systems may
communicate with one another in accordance with a peer-to-peer model, so
that each system may ask for services from any other systems in the
server environment.</p>
<p>The logical communication between the client systems and the server
environment is based on a client-server model, where communication is
only possible between each client system and the server environment.</p>
</blockquote>
<h6 id="the-client-systems">The Client Systems</h6>
<blockquote>
<p>A client system is a hardware &amp; software station through which
one or more traders of a market member may log onto the TradeImpact
electronic markets.</p>
<p>Each market defines as "market member" an entity (Bank, Company,
etc.) that has signed a Convention with the appropriate Management
Committee. The Convention s pecifies the member's identification data
and the rules for his participation to the market activities. A market
member is thus a resource with a profile and is recorded in the market
database.</p>
<p>A member’s trader is an entity uniquely recognized on the market
(through a logon name and a password), and has a profile that specifies
which operations he is authorized to perform on the market. A member’s
trader is also a resource recorded in the market database.</p>
</blockquote>
<h2 id="modeling-markets-using-data-classes">Modeling Markets Using Data
Classes</h2>
<blockquote>
<p>The resources and functions of a generic market are modeled by data
classes, briefly known as <strong>Classes</strong>.</p>
<p>Each class represents a market resource (or a functional part of it)
and models both the characteristics of such resource and the operations
that may be performed on it.</p>
</blockquote>
<h6 id="class-data-structure-and-records">Class Data Structure and
Records</h6>
<blockquote>
<p>A class is defined by means of a data structure and contains a set of
instances of this data structure, called <strong>Records</strong>. In a
class, all records have the same number of fields; fields having the
same name also have the same data type. A record represents a
well-defined market object (a proposal, an order, a trader, etc.).</p>
<p>To ensure data consistency, all records in a class have a
<strong>Version</strong>, which a client may use to check whether the
records in his possession correspond to those currently managed by the
server.</p>
<p>Each class has at least one <strong>Unique Key</strong>, that is, an
ordered set of fields whose values uniquely identify the records in the
class.</p>
<p>Each record in a class has a <strong>Timestamp</strong>, which
identifies the temporal order of such record with respect to the other
records in the class.</p>
</blockquote>
<h6 id="operating-on-classes">Operating on Classes</h6>
<blockquote>
<p>The definition of a class includes the <strong>Actions</strong> that
can be performed on the records in the class.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 19%" />
<col style="width: 77%" />
</colgroup>
<thead>
<tr>
<th>ACTION</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>ADD</td>
<td>Add a new record</td>
</tr>
<tr>
<td>REWRITE</td>
<td>Update an existing record</td>
</tr>
<tr>
<td>DELETE</td>
<td>Logically delete an existing record</td>
</tr>
<tr>
<td>KILL</td>
<td>Physically delete an existing record</td>
</tr>
</tbody>
</table>
<blockquote>
<p>On any of the classes that supports them, a client may perform
additional operations, such as starting <strong>Subscriptions</strong>
in order to be notified of the changes occurring on the records in the
class, and submitting <strong>Queries</strong> to retrieve a finite set
of records.</p>
</blockquote>
<h2 id="tradeimpact-services">TradeImpact Services</h2>
<blockquote>
<p>TradeImpact implements several services that can be accessed and used
by all authorized traders. A service supports a set of classes and
provides users with trading-oriented or technical services.</p>
</blockquote>
<h6 id="info-broadcasting-service-info_brt">Info Broadcasting Service
(INFO_BRT)</h6>
<blockquote>
<p>The INFO_BRT service broadcasts the following information to all
traders requesting it:</p>
</blockquote>
<ul>
<li><p>MTS registry</p></li>
<li><p>Market registry</p></li>
<li><p>Public information</p></li>
</ul>
<blockquote>
<p>The classes supported by the INFO_BRT service can only be subscribed
(action requests are not allowed).</p>
</blockquote>
<h6 id="trading-service-txn-and-txn_info_priv">Trading Service (TXN and
TXN_INFO_PRIV)</h6>
<blockquote>
<p>The TXN and TXN_INFO_PRIV services are the transactional services
that support the classes that may be used by traders to perform typical
trading operations, and to receive private information.</p>
<p>The TXN service enables sending high priority transactions to the
Central System, such as:</p>
</blockquote>
<ul>
<li><p>Proposal quick/smart editing</p></li>
</ul>
<blockquote>
<p>The TXN_INFO_PRIV service enables sending of transactions of
middle-low priority, such as:</p>
</blockquote>
<ul>
<li><p>Trade on/trade off</p></li>
<li><p>Proposal insertion/modification</p></li>
<li><p>Order insertion</p></li>
</ul>
<blockquote>
<p>as well as receiving private information, such as:</p>
</blockquote>
<ul>
<li><p>Information about transactions sent through the TXN,
TXN_INFO_PRIV services</p></li>
<li><p>Information about: Deals, Trades, …</p></li>
</ul>
<blockquote>
<p>Action requests are allowed on the classes supported by the TXN,
TXN_INFO_PRIV services.</p>
<p><strong>NOTE</strong></p>
<p>Service TXN_INFO_PRIV is used instead of the TXN service, in
platforms where the TXN service is not provided. The list of services
available on the various MTS platforms is given below (paragraph “<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>”).</p>
</blockquote>
<h6 id="datafeed">DATAFEED</h6>
<blockquote>
<p>The DATAFEED service supports classes that allow surveillance members
to get ticker information about market data, such as:</p>
</blockquote>
<ul>
<li><p>Static market data (e.g. member directory, product list)</p></li>
<li><p>Member and Traders statuses</p></li>
<li><p>Trading operations performed by market members during the current
trade day</p></li>
<li><p>Trading traffic</p></li>
<li><p>Summary data reports</p></li>
</ul>
<blockquote>
<p>The classes supported by the DataFeed service can only be
subscribed.</p>
</blockquote>
<h6 id="query">QUERY</h6>
<blockquote>
<p>The QUERY service supports classes that allow members to retrieve
historical data through:</p>
</blockquote>
<ul>
<li><p>Search for class data, by sending to the Central System an SDP
query specific to the class</p></li>
<li><p>Receive the result set</p></li>
</ul>
<h6 id="ip-provider-service-ip_request">IP Provider Service
(IP_REQUEST)</h6>
<blockquote>
<p>The IP Provider service is a specialized technological service that
has the task of managing, allocating and distributing the transport
addresses associated with traders.</p>
<p>The client implementing a trader must retrieve the transport
addresses associated with this trader from the IP Provider service.
Using these transport addresses, the client may set up the transport
connections that support the SSP sessions through which the trader may
access all other TradeImpact services.</p>
<p>At the time this document has been issued, the IP_REQUEST service
works in two modes, which are based on two different service
implementations in the TradeImpact system:</p>
</blockquote>
<ul>
<li><p>The mode currently used on some platforms requires the client’s
connection to the specific platform which hosts the service to which the
trader is enabled, and the information provided by the service concerns
access points for services on that platform. In the document, this mode
will be indicated as “IP SP – single platform”.</p></li>
<li><p>The mode introduced in the context of “TradeImpact MTS Platform
Segmentation” requires the client’s connection to a single centralized
service, and the information provided by the service concerns access
points for services on all platforms (for the markets to which the
trader is enabled). In the document, this mode will be indicated as “IP
SP – centralized”.</p></li>
</ul>
<h6
id="availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</h6>
<blockquote>
<p>As to the date of this document, availablity of IP SP access modes
and services depends on the specific MTS platform, as shown in the
tables below.</p>
<p>The following table lists the IP SP mode used on each platform.</p>
</blockquote>
<table style="width:91%;">
<colgroup>
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;">MTS_BV</th>
<th style="text-align: center;">MTS_CMF</th>
<th style="text-align: center;">MTS_MMF2</th>
<th style="text-align: center;">MTS_STF</th>
<th style="text-align: center;">MTS_PAF</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: center;"><p>IP SP</p>
<p>centralized</p></td>
<td style="text-align: center;"><p>IP SP</p>
<p>centralized</p></td>
<td style="text-align: center;"><p>IP SP</p>
<p>centralized</p></td>
<td style="text-align: center;"><p>IP SP</p>
<p>single platform</p></td>
<td style="text-align: center;"><p>IP SP</p>
<p>single platform</p></td>
</tr>
</tbody>
</table>
<blockquote>
<p>The following table lists the services available on each
platform.</p>
</blockquote>
<table style="width:91%;">
<colgroup>
<col style="width: 31%" />
<col style="width: 10%" />
<col style="width: 11%" />
<col style="width: 13%" />
<col style="width: 13%" />
<col style="width: 11%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;">Service</th>
<th style="text-align: center;">MTS_BV</th>
<th style="text-align: center;">MTS_CMF</th>
<th style="text-align: center;">MTS_MMF2</th>
<th style="text-align: center;">MTS_STF</th>
<th style="text-align: center;">MTS_PAF</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: center;">TXN</td>
<td style="text-align: center;">N</td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;">N</td>
<td style="text-align: center;">N</td>
<td style="text-align: center;">N</td>
</tr>
<tr>
<td style="text-align: center;">INFO_BRT</td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
</tr>
<tr>
<td style="text-align: center;">TXN_INFO_PRIV</td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
</tr>
<tr>
<td style="text-align: center;">DATAFEED</td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;">N</td>
<td style="text-align: center;">N</td>
</tr>
<tr>
<td style="text-align: center;">QUERY</td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;"><strong>Y</strong></td>
<td style="text-align: center;">N</td>
<td style="text-align: center;">N</td>
</tr>
</tbody>
</table>
<h1 id="the-sdp-protocol-suite">The SDP Protocol Suite</h1>
<blockquote>
<p>The SDP (Market Data Protocol) suite is a multi-layer set of
communication protocols that TradeImpact clients and front-end systems
may use to exchange data and other information.</p>
<p>The SDP protocol suite is structured in three layers (SMP, SAP and
SSP), each providing a series of services to the higher layer, thus
making each layer independent of the changes that may affect the other
layers.</p>
<p>This chapter provides an overview of the layers in the SDP protocol
stack and of the communication services they provide.</p>
</blockquote>
<h2 id="the-sdp-protocol-stack"><br />
The SDP Protocol Stack</h2>
<blockquote>
<p><a href="#_Ref99609761">Figure 2</a> shows how a client can use the
SDP protocol stack to access the TradeImpact server platform.</p>
</blockquote>
<figure>
<img src="media/image3.wmf" style="width:4.875in;height:3.35417in" />
<figcaption><blockquote>
<p><span id="_Ref99609761" class="anchor"></span><strong>Figure
2.</strong> The SDP Protocol Stack</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>The SDP protocol stack may be based on any transport network (such as
TCP/IP) satisfying a well-defined set of requirements.</p>
</blockquote>
<h6 id="the-smp-layer">The SMP Layer</h6>
<blockquote>
<p>The SMP layer provides market-level services. It defines the
structure of the classes to be used to send action requests and to
receive notifications/information, as well as the rules to be observed
for subscriptions and queries.</p>
<p>Each market defines its own specific classes and shares common
classes with other markets. Both market-specific and common are fully
described in the relevant SMP documentation.</p>
</blockquote>
<h6 id="the-sap-layer">The SAP Layer</h6>
<blockquote>
<p>The SAP layer provides generalized application-level services giving
access to financial markets and to the classes they define. The SAP
protocol is part of this layer and provides the following services:</p>
</blockquote>
<ul>
<li><p>Logon/Logoff with trader authentication and SSL certificate
check, if the SSL protocol is implemented.</p></li>
<li><p>Providing access addresses (IP, TCP port) for all services on
market platforms</p></li>
<li><p>Processing the transactions and supporting the execution of
action requests coming from clients.</p></li>
<li><p>Management of subscriptions. After starting a subscription to a
class, a client is notified of the changes occurring on the records in
the class. The behavior of a subscription depends on its type, and on an
optional filter that may be used to restrict the set of records notified
to the client.</p></li>
<li><p>Management of queries. A query enables a client to request the
server a finite set of data belonging to one class. An option may be
specified by the client to receive query results as pages or individual
lines.</p></li>
</ul>
<blockquote>
<p>For each market, the relevant documentation describes the definition
of its classes, also including, for example, the action requests,
subscriptions and queries provided for each class.</p>
</blockquote>
<h6 id="the-ssp-layer">The SSP Layer</h6>
<blockquote>
<p>The SSP layer makes the higher layers of the SDP protocol independent
of the transport network used. It provides the following main
features:</p>
</blockquote>
<ul>
<li><p>Opening, closing and managing SSP sessions for data exchange
between client and server</p></li>
<li><p>Exchange of data blocks of a specified length also on streaming
connections, such as TCP</p></li>
<li><p>Packing of one or more SSP PDUs, even of a variable length,
within the same data block</p></li>
<li><p>Compression of data contained in a block, in order to reduce the
occupation of the transmission band</p></li>
<li><p>Encapsulation of the SSL (Security Socket Layer) protocol, in
order to ensure confidentiality, integrity and authentication of the
client-server communication. SSL is required only for Internet
accesses.</p></li>
</ul>
<blockquote>
<p>The SSP layer may use the services of any transport layer, providing
it satisfies some minimum requirements such as, for instance, the
capability of maintaining the sequence and integrity of transmitted
data.</p>
</blockquote>
<h6 id="the-transport-network">The Transport Network</h6>
<blockquote>
<p>The SDP protocol stack (and specifically the SSP layer) may be based
on any transport layer providing the latter is capable of ensuring:</p>
</blockquote>
<ul>
<li><p>Maintenance of the data sequence</p></li>
<li><p>The delivery of all data to the recipient</p></li>
<li><p>The integrity of the data.</p></li>
</ul>
<blockquote>
<p>The TCP/IP protocol ensures all these requirements and is used widely
for communication on WAN’s.</p>
</blockquote>
<h2 id="client-server-communication"><br />
Client-Server Communication</h2>
<blockquote>
<p>A trader requires as many access connections as many TradeImpact
services he wants to access and use.</p>
</blockquote>
<figure>
<img src="media/image4.wmf" style="width:5in;height:3.83333in" />
<figcaption><blockquote>
<p><strong>Figure 3.</strong> Client-Server Communication</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>An access connection consists of an SSP session based on a dedicated,
underlying Transport Connection.</p>
</blockquote>
<figure>
<img src="media/image5.wmf" style="width:3.90625in;height:0.8125in" />
<figcaption><blockquote>
<p><strong>Figure 4.</strong> Access Connection</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>On the SSP session established to connect a trader with a given
TradeImpact service, the SAP client supporting the trader will exchange,
with the SAP server, the SAP PDUs that support the operations that the
trader performs on the classes made available by that service.</p>
</blockquote>
<h2 id="structure-of-sdp-messages"><br />
Structure of SDP Messages</h2>
<blockquote>
<p>Communication in the SDP protocol is based on the exchange of
messages. Messages are always sent in blocks.</p>
<p>The structure of a generic block of data used by the SDP protocol is
shown in Figure 5.</p>
</blockquote>
<figure>
<img src="media/image6.wmf" style="width:4.72917in;height:3.47917in" />
<figcaption><blockquote>
<p><strong>Figure 5.</strong> Detail of SDP Messages</p>
</blockquote></figcaption>
</figure>
<h2 id="basic-data-types"><br />
Basic Data Types</h2>
<blockquote>
<p>The table below defines the basic data types used to define classes
and domains and, for each of them, provides a description and the size
(bytes).</p>
</blockquote>
<table style="width:96%;">
<colgroup>
<col style="width: 19%" />
<col style="width: 64%" />
<col style="width: 11%" />
</colgroup>
<thead>
<tr>
<th>SPD DATA TYPE</th>
<th>DESCRIPTION</th>
<th style="text-align: center;">SIZE (bytes)</th>
</tr>
</thead>
<tbody>
<tr>
<td>BOOLEAN</td>
<td>Boolean</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>BYTE</td>
<td>8 bit</td>
<td style="text-align: center;">1</td>
</tr>
<tr>
<td>CHAR</td>
<td>8 bit</td>
<td style="text-align: center;">1</td>
</tr>
<tr>
<td>ENUM</td>
<td>Enumerated type (starting from 0)</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>STRING</td>
<td>Buffer of characters</td>
<td style="text-align: center;">1</td>
</tr>
<tr>
<td>SHORT</td>
<td>Short integer</td>
<td style="text-align: center;">2</td>
</tr>
<tr>
<td>USHORT</td>
<td>Unsigned short integer</td>
<td style="text-align: center;">2</td>
</tr>
<tr>
<td>INT</td>
<td>Signed short integer</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>UINT</td>
<td>Unsigned short integer</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>LONG</td>
<td>Signed long integer</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>ULONG</td>
<td>Unsigned long integer</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>FLOAT</td>
<td>Single precision floating point number</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>DOUBLE</td>
<td>Double precision floating point number</td>
<td style="text-align: center;">8</td>
</tr>
<tr>
<td>LDATE</td>
<td>Date, format yyyymmdd</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>LTIME</td>
<td>Timestamp, format hmmsscc (hour without leading zeros)</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>MTIME</td>
<td>Timestamp, format hmmssmmm (hour without leading zeros)</td>
<td style="text-align: center;">4</td>
</tr>
<tr>
<td>UTIME</td>
<td>Timestamp, format hmmssmmmuuu (hour without leading zeros)</td>
<td style="text-align: center;">8</td>
</tr>
<tr>
<td>STRUCT</td>
<td>Structure</td>
<td style="text-align: center;">-</td>
</tr>
</tbody>
</table>
<h1 id="ssp-layer">SSP Layer</h1>
<blockquote>
<p>The SSP layer of the SDP Protocol Suite guarantees independence of
the means of transport used, as regards both the physical device and the
protocol, for the higher layers of the SDP protocol suite.</p>
<p>In addition, the SSP layer guarantees a secure data transport by
implementing the SSL handshaking function, which is a preliminary step
required for Internet access.</p>
<p>The SSP layer comprises the following protocols:</p>
</blockquote>
<ul>
<li><p>The blocking/packing protocol</p></li>
<li><p>Optionally, the Secure Socket Layer protocol (SSL).</p></li>
<li><p>The Market Session Protocol (SSP).</p></li>
</ul>
<blockquote>
<p>The SSP layer may lie on any transport layer providing it satisfies
the requirements indicated below.</p>
</blockquote>
<h2 id="blocking-and-packing-protocol"><br />
Blocking and Packing Protocol</h2>
<blockquote>
<p>The blocking/packing protocol is based on a fixed-length block header
that the SSP client and the SSP server must add, as a prefix, to the
data (that is, to one or more SSP PDUs) to be sent to the other party on
the Transport connection. The blocking/packing protocol supports the
following services:</p>
</blockquote>
<ul>
<li><p>Blocking, which is used to exchange a block of data of a known
length</p></li>
<li><p>Packing, which is used to encapsulate one or more PDUs in the
same block</p></li>
<li><p>Compression, which is used to compress the data contained in the
block.</p></li>
</ul>
<h3 id="blocking-and-packing">Blocking and Packing</h3>
<blockquote>
<p>The <strong>blocking</strong> feature is used to exchange blocks of
data of a specified length also on streaming connections, such as TCP
connections. Blocking is implemented by means of a block header which
specifies the length of the block itself.</p>
<p>The <strong>packing</strong> feature is used to send or receive
blocks containing several SSP PDUs even of a variable length. Packing is
implemented by specifying in the block header the number of SSP PDUs
present in the block and using a header for each individual SSP PDU that
specifies its type and length.</p>
</blockquote>
<h3 id="data-compression">Data Compression</h3>
<blockquote>
<p>If the data compression feature was enabled during the SSP session
opening phase, the sender (SSP client or SSP server) can choose to
compress the data contained in a block (i.e. the SSP PDUs that the block
contains) before sending it to the other party. For details about the
compression algorithm used, refer to the "<a
href="#technical-notes">Technical Notes</a>" chapter on page 97.</p>
<p>When a block contains compressed data, the sender must set bit 0 of
the <em>BlockFlags</em> field in the block header to 1. In this way, the
receiving party knows that the data in the block are compressed and can
decompress them before processing them.</p>
<p>The block header is always uncompressed.</p>
</blockquote>
<h3 id="block-header-format">Block Header Format</h3>
<blockquote>
<p>The block header is a prefix with a fixed length that SSP client and
SSP server must add as a prefix to the data (that is, a set of one or
more SSP PDUs) to be sent to the other party on the transport
connection. The block header structure is described in the table
below.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>BlockNumber</td>
<td>ULONG</td>
<td><p>Progressive data block number of those sent on the SSP session
(initial value 1).</p>
<p>See Note 1 and Note 2 for more details.</p></td>
</tr>
<tr>
<td>NumMsg</td>
<td>USHORT</td>
<td>Number of SSP PDUs contained in the block.</td>
</tr>
<tr>
<td>BlockFlags</td>
<td>ULONG</td>
<td><p>String of bits, each of which indicates whether the corresponding
function is supported for the block or not.</p>
<p>Bit 0 – indicates whether the sender has compressed the data in the
block or not (0, the data in the block is uncompressed; 1, data in the
block is compressed). The block header is always uncompressed.</p>
<p>Bit 1 .. Bit 31 – Reserved for future use.</p></td>
</tr>
<tr>
<td>BlockLen</td>
<td><strong>USHORT/ULONG</strong></td>
<td><p>Block length, in bytes (excluding the block header length). It
must be calculated using the xdr-sizeof() function.</p>
<p><strong>In case of use of blocks less than 64 KB, it is possible to
continue using this field as a USHORT type.</strong></p>
<p><strong>In order to use blocks equal to or greater than 64 KB, it is
mandatory to use this field as a ULONG type.</strong></p>
<p><strong>The Central System is able to handle both Data Types USHORT
and ULONG.</strong></p>
<p><strong>The possibility to use blocks equal to or greater than 64 KB
is available for CMF, BV and SWAP markets.</strong></p></td>
</tr>
</tbody>
</table>
<blockquote>
<p><strong>Note 1</strong></p>
<p>When an SSP session is opened (or reopened), the value of the
<em>BlockNumber</em> field must be reset to 1 by both counterparts of
the SSP session.</p>
<p>In other words, the SSP client must set the <em>BlockNumber</em>
field of the header of the block used to send the
<strong>SSPConOpenReq</strong> PDU to 1. Similarly, the SSP server will
set the <em>BlockNumber</em> field of the header of the block used to
send the reply <strong>SSPConOpenRes</strong> PDU to 1. Each other party
will then increase, independently from one another, the
<em>BlockNumber</em> each time it sends a block, until the SSP session
is closed.</p>
<p><strong>Note 2</strong></p>
<p>The SSP server does not guarantee delivering of SSP PDUs in
sequential order, therefore a client application can receive a PDU
headed by a <em>BlockNumber</em> lower than the <em>BlockNumber</em> of
an already received SSP PDU.</p>
<p>On the contrary, the client application must order the sequence of
the SSP PDUs to be sent, and set field <em>BlockNumber</em> to
increasing sequential values.</p>
</blockquote>
<h2 id="market-session-protocol-ssp">Market Session Protocol (SSP)</h2>
<blockquote>
<p>The Market Session Protocol (SSP) is the main protocol of the SSP
layer and supports the following services:</p>
</blockquote>
<ul>
<li><p>Management of SSP sessions between SSP clients and SSP
server:</p></li>
</ul>
<ul>
<li><p>SSL handshaking (for Internet access)</p></li>
<li><p>Opening and closing of an SSP session by an SSP client</p></li>
<li><p>Negotiation and configuration of the characteristics of the
session (compression, alive interval timeout, communication window size,
etc.)</p></li>
</ul>
<ul>
<li><p>Exchange of data between SSP clients and SSP server:</p></li>
</ul>
<ul>
<li><p>Transmission of data by SSP clients to the SSP server (for
example, transaction or subscription requests) and reception of
replies</p></li>
<li><p>Reception of asynchronous data from the SSP server</p></li>
<li><p>Management of the “communication window”. The communication
window defines the maximum number of messages that an SSP client can
send to the SSP server on an SSP session without waiting for an
acknowledgement.</p></li>
</ul>
<ul>
<li><p>Other services:</p></li>
</ul>
<ul>
<li><p>"Keep alive" feature, to manage the connection during an idle
period</p></li>
<li><p>"Probe" feature, which is used by the SSP server to check and
measure the client's reactivity.</p></li>
</ul>
<h3
id="opening-an-ssp-session-and-negotiating-its-characteristics">Opening
an SSP Session and Negotiating its Characteristics</h3>
<blockquote>
<p>It is up to the SSP client supporting a trader to open all the SSP
sessions used by the trader to access the desired TradeImpact services.
A trader requires a dedicated SSP session for each TradeImpact service
he wants to access. Only one SSP session can be opened on a TCP/IP
transport connection.</p>
<p>To set up an SSP session, an SSP client must therefore:</p>
</blockquote>
<ol type="1">
<li><p>Open the underlying TCP connection (socket) using the appropriate
IP address and the TCP port number of the TradeImpact service to be
connected.</p></li>
<li><p>Perform the handshaking procedure required by the SSL protocol,
if SSL is a required feature</p></li>
<li><p>Send the SSP server the <strong>SSPConOpenReq</strong> PDU to
request to open an SSP session having the specified characteristics. In
turn, the SSP server checks and, if necessary, changes the parameters
contained in the request to open and returns them to the SSP client in
the <strong>SSPConOpenRes</strong> PDU. This mechanism is illustrated in
.</p></li>
</ol>
<figure>
<img src="media/image7.wmf" />
<figcaption><blockquote>
<p><strong>Figure 6.</strong> Opening an SSP Session and Negotiating its
Characteristics</p>
</blockquote></figcaption>
</figure>
<h6 id="ssl-handshaking">SSL Handshaking</h6>
<blockquote>
<p>SSL is a protocol designed to work at the socket layer, to protect
any higher level built on the socket.</p>
<p>SSL provides for encryption and authentication, thus ensuring secure
Internet transactions dealing with private data, e.g. payments by credit
card.</p>
<p>SSL is mandatory for Internet based applications.</p>
<p>The SSL handshake occurs when the client attempts to establish a
connection with the server. In this phase:</p>
</blockquote>
<ul>
<li><p>client and server exchange their certificates. The server
authenticates the client’s certificate and verifies the certification
authority</p></li>
<li><p>client and server agree on a cryptographic system and generate
their keys</p></li>
</ul>
<blockquote>
<p><strong>NOTE</strong></p>
<p>The following SSL protocol features are not supported:</p>
</blockquote>
<ul>
<li><p>SSL session resuming. This feature is not implemented due to
security reasons. During SSL session resuming, a possibile attacker
might have enough time and data to spot the keys.</p></li>
<li><p>SSL re-handshaking. This feaure is not implemented since it would
be useful only for long-lasting sessions</p></li>
</ul>
<h6 id="negotiating-ssp-session-characteristics">Negotiating SSP Session
Characteristics </h6>
<blockquote>
<p>During the SSP session opening phase, the SSP client and the SSP
server may negotiate the values of some session characteristics.
Negotiation is performed in such a way that the SSP client proposes the
desired values of these characteristics in the
<strong>SSPConOpenReq</strong> PDU, and then accepts the values returned
by the SSP server in the corresponding <strong>SSPConOpenRes</strong>
PDU without any conditions. The values established remain valid until
the session is closed or they are expressly modified by the SSP
server.</p>
<p>The characteristics negotiated in the opening phase of an SSP session
are:</p>
</blockquote>
<ul>
<li><p>Version of the SSP protocol used in the SSP session</p></li>
<li><p>Maximum size of a block and a SSP PDU</p></li>
<li><p>Whether data compression (that is, compression of the SSP PDU) in
a block is enabled or not</p></li>
<li><p>Size of the communication window, that is, the number of messages
that the SSP client can send to the SSP server without waiting for
acknowledgement</p></li>
<li><p>Time within which the SSP client must send an
<strong>SSPConAlive</strong> PDU and time within which the SSP client
must receive an <strong>SSPConAlive</strong> PDU.</p></li>
</ul>
<h3 id="changing-the-ssp-session-characteristics">Changing the SSP
Session Characteristics</h3>
<blockquote>
<p>The SSP server may take the initiative to change the values of some
characteristics of an SSP session. The SSP server informs the SSP client
of the new values of the modified characteristics using the
<strong>SSPConModifyReq</strong> PDU. When receiving this PDU, the SSP
client must set its own values with the new values received and then it
must answer by sending an <strong>SSPConModifyRes</strong> PDU.</p>
<p>Currently, the SSP server may:</p>
</blockquote>
<ul>
<li><p>Send an <strong>SSPConModifyReq</strong> PDU only during the SAP
logon phase, that is, after having received a
<strong>SAPLogonReq</strong> PDU from the client and before sending back
the related <strong>SAPLogonRes</strong> PDU.</p></li>
<li><p>Use the <strong>SSPConModifyReq</strong> PDU to change the size
of the communication window only.</p></li>
</ul>
<figure>
<img src="media/image8.wmf" style="width:6.20833in;height:2.05208in" />
<figcaption><blockquote>
<p><strong>Figure 7.</strong> Changing the Characteristics of an SSP
Session</p>
</blockquote></figcaption>
</figure>
<h3 id="exchanging-data-in-an-ssp-session">Exchanging Data in an SSP
Session</h3>
<blockquote>
<p>To send the SSP server a SAP PDU created asynchronously by its
Application layer, the SSP client must use an
<strong>SSPSendMsg</strong> PDU.</p>
<p>Conversely, the SSP server uses <strong>SSPSendMsgAck</strong> PDUs
or <strong>SSPSendData</strong> PDUs to send the SSP client data for the
Application layer of the client.</p>
<p>The difference between the <strong>SSPSendMsgAck</strong> PDU and the
<strong>SSPSendData</strong> PDU is that the former also acknowledges an
<strong>SSPSendMsg</strong> PDU sent previously by the SSP client,
decreasing by one the number of outstanding <strong>SSPSendMsg</strong>
PDUs (see “<a href="#managing-the-communication-window">Managing the
Communication Window</a>” on page 28 for further details).</p>
</blockquote>
<h3 id="managing-the-communication-window">Managing the Communication
Window</h3>
<blockquote>
<p>The communication window is a mechanism used to regulate the flow of
data sent by the SSP client to the SSP server. In fact, the size of the
communication window determines the maximum number of
<strong>SSPSendMsg</strong> PDUs that the SSP client can send without
waiting for acknowledgement from the SSP server.</p>
<p>In practice, at a given time, the SSP client can send an
<strong>SSPSendMsg</strong> PDU on the SSP session only if:</p>
<p><em>“Number of outstanding <strong>SSPSendMsg</strong> PDUs” &lt;
“Communication Window Size”</em></p>
<p>Where:</p>
</blockquote>
<ul>
<li><p>The size of the communication window is set, when the SSP session
is opened, to the value of the <em>ComunicWindowSizeRes</em> field of
the <strong>SSPConOpenRes</strong> PDU and remains unchanged for the
entire session, unless the SSP server changes it using an
<strong>SSPConModifyRes</strong> PDU. By convention, a negative value
(-1) indicates that the communication window is of an infinite size; in
this case, the SSP client may always send an <strong>SSPSendMsg</strong>
PDU irrespective of the number of outstanding PDUs.</p></li>
<li><p>The number of outstanding <strong>SSPSendMsg</strong> PDUs is set
to 0 when the session is opened, and is increased by 1 whenever the SSP
client sends an <strong>SSPSendMsg</strong> PDU and decreased by 1
whenever the SSP client receives an <strong>SSPSendMsgAck</strong>
PDU.</p></li>
</ul>
<blockquote>
<p>Each <strong>SSPSendMsg</strong> PDU sent by the SSP client when the
rule defined above would prevent it, is discarded by the SSP server,
which sends back in reply an <strong>SSPErrorMsg</strong> PDU containing
the “Communication window size exceeded” error indication.</p>
</blockquote>
<h3 class="Titolo-3-MidTopic" id="alive-mechanism">Alive Mechanism</h3>
<blockquote>
<p>The <em>ClientReceiveAliveIntervalRequest</em> SSP session parameter
specifies the value of the timeout at which the SSP client must close
the SSP session after sending the <strong>SSPErrorMSg</strong> PDU with
an error code of 5 (alive timeout expired).</p>
<p>The SSP client must reset this timeout whenever it receives a valid
data PDU or an <strong>SSPConAlive</strong> PDU from the SSP server. To
stop the timeout expiring and consequently the SSP client closing the
SSP session, the SSP server must therefore send an
<strong>SSPConAlive</strong> PDU if it has no data to be sent to the SSP
client before the timeout expires.</p>
<p>The <em>ClientSendAliveIntervalRequest</em> parameter specifies the
value of the timeout at which the SSP client must send an
<strong>SSPConAlive</strong> PDU to prevent the SSP server from closing
the session if the SSP server has not received any data PDU from the SSP
client for a long time.</p>
</blockquote>
<h3 class="Titolo-3-MidTopic" id="probe-mechanism">Probe Mechanism</h3>
<blockquote>
<p>To measure the reactivity of the client and the response times of the
network, the SSP server may send the SPP client one or more
<strong>SSPConProbeReq</strong> PDUs, each containing the timestamp
corresponding to its transmission in the <em>ProbeData</em> field.</p>
<p>Whenever it receives an <strong>SSPConProbeReq</strong> PDU, the SSP
client must reply by sending the SSP server an
<strong>SSPConProbeRes</strong> PDU containing the same timestamp as
that received in the request PDU.</p>
<p>When it receives an <strong>SSPConProbeRes</strong> PDU, the SSP
server calculates the difference between the timestamp received and the
timestamp of the system time.</p>
</blockquote>
<h3 id="closing-an-ssp-session">Closing an SSP Session</h3>
<blockquote>
<p>When it wants to close an SSP session, either the SSP server or the
SSP client must send the <strong>SSPConCloseReq</strong> PDU specifying
the reason for the closure.</p>
<p>The other party must close the session without any conditions and
reply by sending an <strong>SSPConCloseRes</strong> PDU.</p>
<p>An SSP session is always closed automatically when the underlying
TCP/IP socket is closed.</p>
</blockquote>
<h2 id="ssp-server-automaton"><br />
SSP Server Automaton</h2>
<blockquote>
<p>Figure 8 illustrates the finite-state automaton that controls the
operation of an SSP server.</p>
<p><strong>Figure 8.</strong> SSP Server Automaton</p>
</blockquote>
<h2 id="ssp-client-automaton"><br />
SSP Client Automaton</h2>
<blockquote>
<p>Figure 9 illustrates the finite-status automaton that controls the
operation of an SSP client.</p>
</blockquote>
<figure>
<img src="media/image9.wmf" style="width:5.46875in;height:5in" />
<figcaption><blockquote>
<p><strong>Figure 9.</strong> SSP Client Automaton</p>
</blockquote></figcaption>
</figure>
<h1 id="ssp-pdu-reference">SSP PDU Reference</h1>
<blockquote>
<p>The format of the PDUs belonging to the SSP protocol is specified in
this chapter.</p>
</blockquote>
<h2 id="ssp-pdu-common-header"><br />
SSP PDU Common Header</h2>
<blockquote>
<p>An SSP PDU always contains an SSP header and the SSP data managed by
the SSP layer. Some SSP PDUs also include SAP data, which the SSP
protocol manages and transports transparently.</p>
<p>The SSP header is a prefix of a fixed length with the following
format:</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. It must be
calculated using the xdr-sizeof() function.</td>
</tr>
</tbody>
</table>
<h2 id="ssp-session-openclose-pdus">SSP Session Open/Close PDUs</h2>
<h3 id="sspconopenreq">SSPConOpenReq</h3>
<blockquote>
<p>The <strong>SSPConOpenReq</strong> PDU is sent by the SSP client to
the SSP server to request to open an SSP session. Note that the
initiative to request to open the session may only be taken by the SSP
client.</p>
<p>The <strong>SSPConOpenReq</strong> PDU specifies the value proposed
by the SSP client for the following negotiable characteristics of the
session:</p>
</blockquote>
<ul>
<li><p>Maximum size of a block and a packet</p></li>
<li><p>Alive intervals</p></li>
<li><p>Size of the communication window</p></li>
<li><p>Possibility of using data compression or not.</p></li>
</ul>
<table style="width:97%;">
<colgroup>
<col style="width: 27%" />
<col style="width: 18%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 101.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ProtocolVersion</td>
<td>ULONG</td>
<td><p>Version of the SSP protocol to be used. Specify 0 to accept the
version proposed by the SSP server.</p>
<p><em>Reserved for future use.</em></p></td>
</tr>
<tr>
<td>MaxBlkLenRequired</td>
<td><strong>USHORT/ULONG</strong></td>
<td><p>Maximum length of a block expressed in bytes (excluding header
length).</p>
<p><strong>In case of use of blocks less than 64 KB, it is possible to
continue using this field as a USHORT type.</strong></p>
<p><strong>In order to use blocks equal to or greater than 64 KB, it is
mandatory to use this field as a ULONG type.</strong></p>
<p><strong>The Central System is able to handle both Data Types USHORT
and ULONG.</strong></p>
<p><strong>The possibility to use blocks equal to or greater than 64 KB
is available for CMF, BV and SWAP markets only.</strong></p></td>
</tr>
<tr>
<td>MaxPckLenRequired</td>
<td>USHORT</td>
<td>Maximum length of an SSP PDU expressed in bytes (excluding header
length).</td>
</tr>
<tr>
<td>ClientSendAliveIntervalReq</td>
<td>USHORT</td>
<td>Time, in seconds, by which the SSP client must send an
<strong>SSPConAlive</strong> PDU.</td>
</tr>
<tr>
<td>ClientReceiveAliveIntervalReq</td>
<td>USHORT</td>
<td>Time, in seconds, by which the SSP client must receive an
<strong>SSPConAlive</strong> PDU.</td>
</tr>
<tr>
<td>ComunicWindowSize</td>
<td>SHORT</td>
<td><p>Size of the communication window.</p>
<p>A number greater than 0 specifies a finite size, while –1 an infinite
size.</p></td>
</tr>
<tr>
<td>ConnectionFlags</td>
<td>ULONG</td>
<td><p>String of bits, each of which indicates whether the corresponding
function is to be supported on the SSP session or not.</p>
<p>Bit 0 – indicates whether compression of the block data is enabled or
not (0, compression disabled; 1, compression enabled).</p>
<p>Bit 1 .. Bit 31 – Reserved for future use.</p></td>
</tr>
</tbody>
</table>
<h3 id="sspconopenres">SSPConOpenRes</h3>
<blockquote>
<p>The <strong>SSPConOpenRes</strong> PDU is sent by the SSP server to
the SSP client in response to an <strong>SSPConOpenReq</strong> PDU
requesting to open an SSP session.</p>
<p>If the SSP session has been opened successfully (as specified by the
<em>ResultCode</em> field), the PDU returns the value established by the
SSP server for the following negotiable characteristics of the
session:</p>
</blockquote>
<ul>
<li><p>Maximum size of a block and a packet</p></li>
<li><p>Alive times</p></li>
<li><p>Size of the communication window</p></li>
<li><p>Possibility of using data compression or not.</p></li>
</ul>
<table style="width:97%;">
<colgroup>
<col style="width: 27%" />
<col style="width: 18%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 102.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ProtocolVersion</td>
<td>ULONG</td>
<td><p>Version of the SSP protocol to be used.</p>
<p><em>Reserved for future use.</em></p></td>
</tr>
<tr>
<td>ResultCode</td>
<td>LONG</td>
<td><p>0 – open executed successfully.</p>
<p>1 – open not executed due to lack of resources.</p>
<p>2 – open not executed due to inconsistency in the version of the SSP
protocol.</p></td>
</tr>
<tr>
<td>MaxBlkLenRes</td>
<td><strong>USHORT/ULONG</strong></td>
<td><p>Maximum length of a block expressed in bytes (excluding header
length).</p>
<p><strong>In case of use of blocks less than 64 KB, it is possible to
continue using this field as a USHORT type.</strong></p>
<p><strong>In order to use blocks equal to or greater than 64 KB, it is
mandatory to use this field as a ULONG type.</strong></p>
<p><strong>The Central System is able to handle both Data Types USHORT
and ULONG.</strong></p>
<p><strong>The possibility to use blocks equal to or greater than 64 KB
is available for CMF, BV and SWAP markets.</strong></p></td>
</tr>
<tr>
<td>MaxPckLenRes</td>
<td>USHORT</td>
<td>Maximum length of an SSP PDU (excluding header length) expressed in
bytes.</td>
</tr>
<tr>
<td>ClientSendAliveIntervalRes</td>
<td>USHORT</td>
<td>Time, in seconds, by which the SSP client must send an
<strong>SSPConAlive</strong> PDU.</td>
</tr>
<tr>
<td>ClientReceiveAliveIntervalRes</td>
<td>USHORT</td>
<td>Time, in seconds, by which the SSP client must receive an
<strong>SSPConAlive</strong> PDU.</td>
</tr>
<tr>
<td>ComunicWindowSizeRes</td>
<td>SHORT</td>
<td><p>Size of the communication window.</p>
<p>A number greater than 0 specifies a finite size, while –1 specifies
an infinite size.</p></td>
</tr>
<tr>
<td>ConnectionFlags</td>
<td>ULONG</td>
<td><p>String of bits, each of which indicates whether the corresponding
function is to be supported on the SSP session or not.</p>
<p>Bit 0 – indicates whether compression of the data in the block is
enabled or not (0, compression disabled; 1, compression enabled).</p>
<p>Bit 1 .. Bit 31 – Reserved for future use.</p></td>
</tr>
</tbody>
</table>
<h3 id="sspconclosereq">SSPConCloseReq</h3>
<blockquote>
<p>The <strong>SSPConCloseReq</strong> PDU is sent by the SSP client or
the SSP server to request the other party to close the SSP session
without any conditions. The recipient must take the appropriate local
closing actions after which he must send the
<strong>SSPConCloseRes</strong> PDU.</p>
<p>The <em>Reason</em> field specifies the reason for the closure
request.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 103.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>Reason</td>
<td>ENUM</td>
<td><p>The reason of the session closure, as follows:</p>
<p>0 – Normal closure</p>
<p>1 – Closure due to expiry of the alive timeout</p></td>
</tr>
</tbody>
</table>
<h3 id="sspconcloseres">SSPConCloseRes</h3>
<blockquote>
<p>The <strong>SSPConCloseRes</strong> PDU is sent by the SSP client or
the SSP server to the other party in response to an
<strong>SSPConCloseReq</strong> PDU requesting to close the SSP session
without any conditions.</p>
<p>This PDU must only be sent after all the appropriate local actions
have been performed.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 104.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
</tbody>
</table>
<blockquote>

</blockquote>
<h2 id="ssp-session-characteristics-modification-pdus"><br />
SSP Session Characteristics Modification PDUs</h2>
<h3 id="sspconmodifyreq">SSPConModifyReq</h3>
<blockquote>
<p>The <strong>SSPConModifyReq</strong> PDU is sent by the SSP server to
the SSP client to notify the new value to be assigned to one or more
characteristics of the SSP session.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 105.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td><p>Request ID specified by the SSP server.</p>
<p>Must be returned unchanged to the SSP server in the related
<strong>SSPConModifyRes</strong> PDU.</p></td>
</tr>
<tr>
<td>ComunicWindowSize</td>
<td>SHORT</td>
<td><p>New size of the communication window.</p>
<p>A number greater than 0 specifies a finite size, while –1 specifies
an infinite size.</p></td>
</tr>
<tr>
<td>ConnectionFlags</td>
<td>ULONG</td>
<td><p>String of bits, each of which indicates whether the corresponding
function is to be supported on the SSP session or not.</p>
<p>Bit 0 .. Bit 31 – Reserved for future use.</p></td>
</tr>
</tbody>
</table>
<h6 id="details">Details</h6>
<blockquote>
<p>The characteristics of an SSP session whose values may be modified by
the SSP server using the <strong>SSPConModifyReq</strong> PDU are
currently as follows:</p>
</blockquote>
<ul>
<li><p>Size of communication window.</p></li>
</ul>
<blockquote>
<p>Currently, the server may send an <strong>SSPConModifyReq</strong>
PDU only during the SAP logon phase, that is, after having received a
<strong>SAPLogonReq</strong> PDU from the client and before sending back
the related <strong>SAPLogonRes</strong> PDU.</p>
</blockquote>
<h3 id="sspconmodifyres">SSPConModifyRes</h3>
<blockquote>
<p>The <strong>SSPConModifyRes</strong> PDU is sent by the SSP server to
the SSP client in response to an <strong>SSPConNodifyReq</strong> PDU
requesting to modify one or more characteristics of the SSP session and
notifies that the SSP client has modified the session characteristics in
accordance with the new values.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 106.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. The SSP client must return the same value as that
specified by the SSP server in the related
<strong>SSPConModifyReq</strong> PDU.</td>
</tr>
</tbody>
</table>
<h2 id="data-exchange-pdus">Data Exchange PDUs</h2>
<h3 id="sspsendmsg">SSPSendMsg</h3>
<blockquote>
<p>The <strong>SSPSendMsg</strong> PDU is used by the SSP client to send
the SSP server a SAP PDU created by its Application layer.</p>
<p>This PDU is the only one subject to the SSP Protocol flow control.
For further details, see “Managing the Communication Window” on page
28.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 110.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td><strong>Application PDU</strong></td>
<td>-</td>
<td>The SAP PDU that the SSP server must transparently deliver to its
local Application layer.</td>
</tr>
</tbody>
</table>
<h3 id="sspsendmsgack">SSPSendMsgAck</h3>
<blockquote>
<p>The <strong>SSPSendMsgAck</strong> PDU is used by the SSP server to
send a SAP PDU created by its Application layer to the SSP client.</p>
<p>This PDU implicitly acknowledges an outstanding
<strong>SSPSendMsg</strong> PDU. For further details, see “Managing the
Communication Window” on page 28.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 111.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td><strong>Application PDU</strong></td>
<td>-</td>
<td>The SAP PDU that the SSP client must transparently send to its local
Application layer.</td>
</tr>
</tbody>
</table>
<h3 id="sspsenddata">SSPSendData</h3>
<blockquote>
<p>The <strong>SSPSendData</strong> PDU is used by the SSP server to
send a SAP PDU created asynchronously by its Application layer to the
SSP client.</p>
<p>This PDU does not acknowledge an outstanding
<strong>SSPSendMsg</strong> PDU. For further details, see “Managing the
Communication Window” on page 28.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 112.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td><strong>Application PDU</strong></td>
<td>-</td>
<td>The SAP PDU that the SSP client must transparently deliver to its
local Application layer.</td>
</tr>
</tbody>
</table>
<h2 id="session-alive-keep-pdus">Session Alive Keep PDUs</h2>
<h3 id="sspconalive">SSPConAlive</h3>
<blockquote>
<p>The <strong>SSPConAlive</strong> PDU can be used by the SSP server or
SSP client to notify the other party that it is present following an
idle period on the SSP session.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 107.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
</tbody>
</table>
<h2 id="session-performance-probe-pdus">Session Performance Probe
PDUs</h2>
<h3 id="sspconprobereq">SSPConProbeReq</h3>
<blockquote>
<p>The <strong>SSPConProbeReq</strong> PDU may be sent by the SPP server
to an SSP client to measure the reactivity of the recipient <em>and by
the SSP client to the SSP server to request the current time at central
level.</em></p>
<p>When the SSP client receives this PDU, the SSP client must reply
immediately with an <strong>SSPConProbeRes</strong> PDU, returning
exactly the data contained in the <em>ProbeData</em> field.</p>
<p><em>When the SSP server receives this PDU, it replies immediately
with an <strong>SSPConProbeRes</strong> PDU, returning the current time
of the central system defined as MTIME (hmmssccm).</em></p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 108.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ProbeData</td>
<td><em>ULONG</em></td>
<td>Data reserved for the SSP server.</td>
</tr>
</tbody>
</table>
<h3 id="sspconproberes">SSPConProbeRes</h3>
<blockquote>
<p>An <strong>SSPConProbeRes</strong> PDU must be sent immediately by
the SSP client in response to an <strong>SSPConProbeReq</strong> PDU
received. The <em>ProbeData</em> field must be updated with the contents
of the same field of the <strong>SSPConProbeReq</strong> PDU.</p>
<p><em>An <strong>SSPConProbeRes</strong> PDU must be sent immediately
by the SSP server in response to an <strong>SSPConProbeReq</strong> PDU
received. The ProbeData field contains the current time of the central
system defined as MTIME (hmmssccm).</em></p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 109.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ProbeData</td>
<td><em>ULONG</em></td>
<td><p><em>If sent by the SSP client, this field must be updated exactly
with the value received in the same field of the
<strong>SSPConProbeReq</strong> PDU.</em></p>
<p><em>If sent by the SSP server, this field contains the current time
of the central system defined as MTIME (hmmssccm)</em></p></td>
</tr>
</tbody>
</table>
<h2 id="ssp-error-notification-pdus">SSP Error Notification PDUs</h2>
<h3 id="ssperrormsg">SSPErrorMsg</h3>
<blockquote>
<p>The <strong>SSPErrorMsg</strong> PDU is sent by the SSP server or the
SSP client to the other party to notify an error condition detected on
the SSP session.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>PDU ID</td>
<td>ULONG</td>
<td>Type of the SSP PDU. Must be 113.</td>
</tr>
<tr>
<td>PDULen</td>
<td>USHORT</td>
<td>Length of the SSP PDU (excluding the header) in bytes. Must be
calculated using the xdr-sizeof() function.</td>
</tr>
<tr>
<td>ErrorCode</td>
<td>ENUM</td>
<td><p>The identifier of the error condition, as follows:</p>
<p>0 – No errors</p>
<p>1 – Incorrect Blocking</p>
<p>2 – Incorrect Packing</p>
<p>3 – Unknown SSP PDU type</p>
<p>4 – Communication window size exceeded</p>
<p>5 – Alive timeout expired</p>
<p>6 – SSP protocol error</p>
<p>7 - Invalid compression</p>
<p>8 - Queue size overflow</p></td>
</tr>
</tbody>
</table>
<h1 id="section-2"></h1>
<h1 id="sap-layer">SAP Layer</h1>
<blockquote>
<p>The APPLICATION layer of the SDP protocol provides generalized
services for accessing the markets and the classes they contain.</p>
<p>The main services offered are:</p>
</blockquote>
<ul>
<li><p>Trader's authentication and identification</p></li>
</ul>
<ul>
<li><p>Logging on to (logging off from) the MTS Service
Provider</p></li>
<li><p>Changing the trader’s password</p></li>
</ul>
<ul>
<li><p>Retrieving IP addresses and TCP ports for services</p></li>
<li><p>Executing actions on the classes</p></li>
</ul>
<ul>
<li><p>Transmitting action requests on the market classes
(transactions)</p></li>
<li><p>Requesting the status of a transaction</p></li>
</ul>
<ul>
<li><p>Starting/stopping subscriptions and receiving
notifications</p></li>
<li><p>Creating and managing queries</p></li>
<li><p>Creating and managing filters</p></li>
<li><p>Other functions:</p></li>
</ul>
<ul>
<li><p>Aligning data in a class</p></li>
</ul>
<h2 id="managing-the-logonlogoff-sequence"><br />
Managing the Logon/Logoff Sequence</h2>
<blockquote>
<p>Before exchanging any other SAP PDU with the SAP server on an SSP
session, the SAP client must log onto the involved TradeImpact service
successfully.</p>
<p>To submit a logon request, the SAP client must send a
<strong>SAPLogonReq</strong> PDU, which specifies the fully qualified
name (in the format <a
href="mailto:Trader@Member"><em>TraderName</em></a><strong>@</strong><a
href="mailto:Trader@Member"><em>MemberName</em></a>) and password of the
trader. The logon request also contains information about the client,
such as the signature and version of the client software, and specifies
the TradeImpact service to be logged on.</p>
<p>Having made the necessary checks, the SAP server responds with a
<strong>SAPLogonRes</strong> PDU, which indicates whether the logon
request has been accepted or refused (in the latter case, it also
indicates the reason for refusal). The response also contains
information about the server, such as the date and time on the central
system and the version of the application services that it supports.</p>
<p>At the time this document has been issued, the Logon authentication
works in two modes, which are based on two different implementations in
the TradeImpact system:</p>
</blockquote>
<ul>
<li><p>in the mode currently used on some platforms authentication is
done on the specific platform to which Logon is directed, and is valid
for that platform and its related markets and services.</p></li>
<li><p>in the mode introduced in the context of “TradeImpact MTS
Platform Segmentation” (“single sign-on”), authentication is done on a
centralized system, and is valid for all TradeImpact platforms and
related markets and services (to which the trader is enabled). The
system responsible for authentication will host the basic information
about traders, which will enable authentication, such as traders’
passwords and expire time, while more speciific information, such as
trader’s email, phone, etc., will be hosted on the market
platform.</p></li>
</ul>
<p>The following table lists the Logon authentication mode used on each
platform.</p>
<table style="width:91%;">
<colgroup>
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;">MTS_BV</th>
<th style="text-align: center;">MTS_CMF</th>
<th style="text-align: center;">MTS_MMF2</th>
<th style="text-align: center;">MTS_STF</th>
<th style="text-align: center;">MTS_PAF</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: center;"><p>Single</p>
<p>Sign-On</p></td>
<td style="text-align: center;"><p>Single</p>
<p>Sign-On</p></td>
<td style="text-align: center;"><p>Single</p>
<p>Sign-On</p></td>
<td style="text-align: center;"><p>Platform</p>
<p>Sign-On</p></td>
<td style="text-align: center;"><p>Platform</p>
<p>Sign-On</p></td>
</tr>
</tbody>
</table>
<blockquote>
<p>The general rules for the logon operation are as follows:</p>
</blockquote>
<ul>
<li><p>The logon is the first operation that is to be carried out by the
SAP client on an SSP session.</p></li>
<li><p>Only one logon operation can be performed on each SSP
session.</p></li>
<li><p>The logon operation does not entail an automatic connection to a
market but simply identifies and authenticates the trader who performed
it.</p></li>
<li><p>When receiving a logon request, the server checks the integrity
and consistence of data enclosed in the client’s certificate, if SSL is
active</p></li>
<li><p>Appropriate SMP registry classes specify the profile of each
member and his traders, and in particular the maximum number of
transactions that a member (and each of his traders) may be running at
the same time on the server.</p></li>
</ul>
<blockquote>
<p>Figure 10 illustrates the PDUs exchanged in the logon phase.</p>
</blockquote>
<figure>
<img src="media/image10.wmf" />
<figcaption><blockquote>
<p><strong>Figure 10.</strong> Logon Sequence</p>
</blockquote></figcaption>
</figure>
<h3 id="modifying-the-session-characteristics-at-logon-time">Modifying
the Session Characteristics at Logon Time</h3>
<blockquote>
<p>Figure 10 shows that, before sending the <strong>SAPLogonRes</strong>
PDU in response to a logon request, the SAP server may modify one or
more characteristics of the SSP session (for details, see “<a
href="#changing-the-ssp-session-characteristics">Changing the SSP
Session Characteristics</a>” on page 27).</p>
<p>For example, when an SSP session is established, the size of the
communication window is set to an arbitrary value defined on the SSP
layer irrespective of the trader’s profile. The SAP server may therefore
need to redefine the size of the communication window in accordance with
the maximum number of outstanding transactions specified in the trader’s
profile and the member’s profile.</p>
</blockquote>
<h2 id="retrieving-ip-addresses-and-tcp-ports-for-services"><br />
Retrieving IP addresses and TCP ports for services</h2>
<blockquote>
<p>To work on a platform/market, the trader must open one session for
each service he is enabled to.</p>
<p>A trader can retrieve the IP address and TCP port assigned to the
transaction and information services provided by MTS markets, by means
of the IP_REQUEST service, in one of the following modes:</p>
</blockquote>
<ul>
<li><p>If the trader works on platforms where the IP_REQUEST service is
realized in “IP SP – centralized” mode, he shall send the
<strong>SAPAddressServiceReqExt</strong> PDU to the centralized IP
Service provider.</p></li>
</ul>
<blockquote>
<p>The returned <strong>SAPAddressServiceResExt</strong> PDU contains
the list of &lt;IP, TCP port&gt; addresses assigned to each service
provided by each platform, for which the trader is enabled.</p>
</blockquote>
<ul>
<li><p>Otherwise, he shall send the
<strong>SAPAddressServiceReq</strong> PDU to the IP Service provider
system specific to the platform hosting the market services.</p></li>
</ul>
<blockquote>
<p>The returned <strong>SAPAddressServiceRes</strong> PDU contains the
list of &lt;IP, TCP port&gt; addresses assigned to each service provided
the specific platform.</p>
<p>The following table lists the “SAPAddressService” PDU type used on
each platform (either [SAPAddressService]ReqExt/ResExt or
[SAPAddressService]Req, Res).</p>
</blockquote>
<table style="width:91%;">
<colgroup>
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
<col style="width: 18%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;"><strong>MTS_BV</strong></th>
<th style="text-align: center;"><strong>MTS_CMF</strong></th>
<th style="text-align: center;"><strong>MTS_MMF2</strong></th>
<th style="text-align: center;"><strong>MTS_STF</strong></th>
<th style="text-align: center;"><strong>MTS_PAF</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: center;"><p>ReqExt</p>
<p>ResExt</p></td>
<td style="text-align: center;"><p>ReqExt</p>
<p>ResExt</p></td>
<td style="text-align: center;"><p>ReqExt</p>
<p>ResExt</p></td>
<td style="text-align: center;"><p>Req</p>
<p>Res</p></td>
<td style="text-align: center;"><p>Req</p>
<p>Res</p></td>
</tr>
</tbody>
</table>
<h2 id="changing-a-traders-password"><br />
Changing a Trader’s Password</h2>
<blockquote>
<p>A trader can change his password using the appropriate feature made
available by the SAP layer. Only the password string may be changed, but
not the password policies (such as the format of the password, period of
validity, modification method, constraints, etc.).</p>
<p>A trader may need to change his password for either of the following
reasons:</p>
</blockquote>
<ul>
<li><p>Security reasons, although when the current password is still
valid. The new password may be specified at logon time in the
<strong>SAPLogonReq</strong> PDU or during a session using the
<strong>SAPChangePasswordReq</strong> PDU.</p></li>
<li><p>The password has expired. The SAP server returns a
<strong>SAPLogonRes</strong> PDU with the <em>Result</em> field set to 8
in response to a logon request if the trader’s password has expired. In
such case, the trader is not allowed to log onto any TradeImpact service
until a new valid password is defined using the
<strong>SAPLogonReq</strong> PDU.</p></li>
</ul>
<blockquote>
<p>The change password request is only accepted if all of the following
conditions are satisfied: the trader’s fully qualified name and password
are valid and the new password is a valid password string.</p>
</blockquote>
<h6 id="changing-the-password-at-logon-time">Changing the Password at
Logon Time</h6>
<blockquote>
<p>A trader may change his password at any logon time. To do that, the
SAP client must specify the current password in the P<em>assword</em>
field and the new password in the <em>NewPassword</em> field of the
<strong>SAPLogonReq</strong> PDU carrying the logon request.</p>
<p>The SAP server returns the <strong>SAPLogonRes</strong> PDU in
response, indicating whether the logon request (and, thus, the change
password request) has been rejected due to any errors or accepted
(<em>Result</em> field set to 0 – Login OK). In the latter case, the new
password will be enabled immediately.</p>
</blockquote>
<h6 id="changing-the-password-during-a-session">Changing the Password
During a Session</h6>
<blockquote>
<p>After having logged onto a service on an SSP session, at any time a
trader may change his password by directing the SAP client to send a
<strong>SAPChangePasswordReq</strong> PDU to the SAP server. In addition
to the fully qualified trader name in the format <a
href="mailto:Trader@Member"><em>TraderName</em></a><strong>@</strong><a
href="mailto:Trader@Member"><em>MemberName</em></a>, the change password
request must specify both the old and new passwords.</p>
<p>The <strong>SAPChangePasswordRes</strong> PDU returned in response by
the SAP server indicates whether the change password request has been
accepted or refused (in the latter case, it also specifies the reason
for refusal).</p>
</blockquote>
<h3 id="password-syntax-and-validation-rules">Password Syntax and
Validation Rules</h3>
<blockquote>
<p>Any string of 8 to up 16 alphanumeric characters including at least a
letter and at least a digit.</p>
<p>In addition, the specified string must be different from the current
password and from the two “tradername” and “membername” strings that
make up the fully qualified trader name specified in the
<em>UserName</em> field.</p>
</blockquote>
<h2 id="executing-actions-on-a-class"><br />
Executing Actions on a Class</h2>
<blockquote>
<p>The “action execution” service of the SAP layer enables the market
client (on behalf of a trader) to deliver to the market server a request
to execute an action on any class and receive the corresponding response
once the action has been executed.</p>
<p>A valid action request causes a transaction to be activated in the
context of the TradeImpact service supporting the market class to which
the action request is addressed. The transaction executes the action, if
possible, returning an appropriate result when it is terminated.</p>
<p>The response that the server sends to the client therefore contains
the result of the transaction and ensures the recipient that the
transaction is terminated. Optionally, the response can also contain the
class record generated as output by the transaction.</p>
<p>From the point of view of the SSP protocol, executing an action
consists in the SAP client sending a <em>SAP request</em> <em>PDU</em>
to the SAP server and receiving the corresponding <em>SAP response</em>
<em>PDU</em>.</p>
<p>The Central System provides three formats for the <em>SAP request
PDU</em> and the corresponding <em>SAP response PDU</em> . The formats
differ for the information about the time spent by the Central System to
work out the request:</p>
</blockquote>
<ul>
<li><p><strong>SAPExtActionReq</strong>,
<strong>SAPExtActionRes</strong>: the time can be calculated as
difference of two timestamps included in the SAPExtActionRes PDU,
expressed in microseconds</p></li>
<li><p><strong>SAPMonitoredActionReq</strong>,
<strong>SAPMonitoredActionRes</strong>: the time can be calculated as
difference of two timestamps included in the SAPMonitoredActionRes PDU,
expressed in milliseconds</p></li>
<li><p><strong>SAPActionReq</strong>, <strong>SAPActionRes</strong>: no
timestamp is provided</p></li>
</ul>
<blockquote>
<p>Not all formats are available on all markets, as outlined in the
table below. Usage of <strong>SAPExtActionReq</strong>,
<strong>SAPExtActionRes</strong> is suggested, if supported on the
market.</p>
</blockquote>
<table style="width:95%;">
<colgroup>
<col style="width: 21%" />
<col style="width: 20%" />
<col style="width: 28%" />
<col style="width: 24%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;"><p><strong>PDU</strong></p>
<p><strong>Market</strong></p></th>
<th style="text-align: center;"><strong>SAPExtActionReq<br />
SAPExtActionRes</strong></th>
<th style="text-align: center;"><strong>SAPMonitoredActionReq<br />
SAPMonitoredActionRes</strong></th>
<th style="text-align: center;"><strong>SAPActionReq<br />
SAPActionRes</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: center;"><strong>BV</strong></td>
<td style="text-align: center;">Suggested</td>
<td style="text-align: center;">Supported</td>
<td style="text-align: center;">Deprecated</td>
</tr>
<tr>
<td style="text-align: center;"><strong>CMF</strong></td>
<td style="text-align: center;">Suggested</td>
<td style="text-align: center;">Supported</td>
<td style="text-align: center;">Deprecated</td>
</tr>
<tr>
<td style="text-align: center;"><strong>REPO</strong></td>
<td style="text-align: center;">Suggested</td>
<td style="text-align: center;">Supported</td>
<td style="text-align: center;">Deprecated</td>
</tr>
<tr>
<td style="text-align: center;"><strong>SWAP</strong></td>
<td style="text-align: center;">Suggested</td>
<td style="text-align: center;">Supported</td>
<td style="text-align: center;">Deprecated</td>
</tr>
<tr>
<td style="text-align: center;"><strong>STF</strong></td>
<td style="text-align: center;">Suggested</td>
<td style="text-align: center;">Supported</td>
<td style="text-align: center;">Deprecated</td>
</tr>
<tr>
<td style="text-align: center;"><strong>PAF</strong></td>
<td style="text-align: center;">n.a.</td>
<td style="text-align: center;">n.a.</td>
<td style="text-align: center;">Suggested</td>
</tr>
</tbody>
</table>
<blockquote>
<p>The description and layout of all Class Actions PDUs are detailed in
chapter “<a href="#class-actions-pdus">Class Actions PDUs</a>”.</p>
<p><strong>Note</strong></p>
<p>In the following chapters, descriptions and pictures refer to the
most used PDUs, i.e. SAPExtActionReq/Res.</p>
<p>Anyway the logic and flow valid for SAPExtActionReq/Res are valid
also for SAPMonitoredActionReq/Res, SAPActionReq/Res</p>
</blockquote>
<h3 id="submitting-an-action-request">Submitting an Action Request</h3>
<blockquote>
<p>Following an action request from the market client, the SAP client
prepares and sends to the SAP server a <strong>SAPExtActionReq</strong>
PDU on the SSP session, which specify:</p>
</blockquote>
<ul>
<li><p>The ID of the class</p></li>
<li><p>The ID of a key among those defined by the class that the market
server is to use to retrieve the record involved (the key is only
necessary if the action is performed on an existing record).</p></li>
<li><p>The code of the action to be executed and the SMP message
containing the necessary information. The actions that may be executed
on a generic class are listed in the table below.</p></li>
</ul>
<table style="width:97%;">
<colgroup>
<col style="width: 19%" />
<col style="width: 76%" />
</colgroup>
<thead>
<tr>
<th>ACTION</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>ADD</td>
<td>Insert a new record</td>
</tr>
<tr>
<td>REWRITE</td>
<td>Update an existing record</td>
</tr>
<tr>
<td>DELETE</td>
<td>Logically delete a record</td>
</tr>
<tr>
<td>KILL</td>
<td>Physically delete a record</td>
</tr>
</tbody>
</table>
<ul>
<li><p>The unique ID of the request and the one to be associated with
the transaction that will be activated on the server to execute it. The
ID of the request will enable the SAP client to correlate the
<strong>SAPExtActionRes</strong> PDU with the
<strong>SAPExtActionReq</strong> PDU sent previously to request the
action.</p></li>
<li><p>The indication as to whether the <strong>SAPExtActionRes</strong>
PDU is to return or not also the SMP message generated as a consequence
of the execution of the action (as indicated in the
<em>DataInResponse</em> field of the <strong>SAPExtActionReq</strong>
PDU).</p></li>
</ul>
<h3 id="receiving-the-response-to-an-action-request">Receiving the
Response to an Action Request</h3>
<blockquote>
<p>When it receives a <strong>SAPExtActionReq</strong> PDU, the SAP
server delivers the associated action request to the appropriate market
server that supports the target class. The market server activates the
transaction required for its execution. After transaction’s completion,
the SAP server sends the SAP client the <strong>SAPExtActionRes</strong>
PDU, containing the following information:</p>
</blockquote>
<ul>
<li><p>The class ID</p></li>
<li><p>The unique ID’s of the request and of the transaction that
executed it (the same ID’s as those specified by the SAP client in the
<strong>SAPExtActionRes</strong> PDU)</p></li>
<li><p>The notification as to whether the transaction has executed the
action successfully or not, and the <em>ReasonCode</em> generated by the
transaction.</p></li>
<li><p>If the transaction has terminated successfully and the class
supports this feature, the inbound SMP message generated by the
execution of the action</p></li>
<li><p>The class record generated by the market server transaction. The
record is only included in the response if:</p></li>
</ul>
<ul>
<li><p>The <em>DataInResponse</em> flag was set to 1 in the
<strong>SAPExtActionReq</strong> PDU.</p></li>
<li><p>The class supports the feature of returning the generated record
in the <strong>SAPExtActionRes</strong> PDU.</p></li>
</ul>
<blockquote>
<p>The SAP client processes the received
<strong>SAPExtActionRes</strong> PDU. If the action request has been
executed successfully and the PDU also returns the record generated by
the transaction, the SAP client delivers it to the local market
client.</p>
</blockquote>
<h3 id="managing-a-sequence-of-action-requests">Managing a Sequence of
Action Requests</h3>
<blockquote>
<p>Figure 11 illustrates the interaction between a client and the server
following a certain number of action requests originated by the client.
This example assumes that the SSP client is managing a communication
window having size 3 correctly.</p>
</blockquote>
<figure>
<img src="media/image11.png" style="width:6.16042in;height:2.70694in" />
<figcaption><blockquote>
<p><strong>Figure 11.</strong> Sequence of Action Requests with Correct
Management of the Communication Window</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>For explanatory purposes only, Figure 12 shows what happens under the
same conditions when the same window is managed incorrectly by the SSP
client. The figure shows how each action request sent by a client that
exceeds the limit of the communication window causes an error on the SSP
layer of the protocol.</p>
</blockquote>
<figure>
<img src="media/image12.png" style="width:6.16042in;height:3.91389in" />
<figcaption><blockquote>
<p><strong>Figure 12.</strong> Sequence of Action Requests with
Incorrect Management of the Communication Window</p>
</blockquote></figcaption>
</figure>
<h2 id="managing-transactions">Managing Transactions</h2>
<h3 id="defining-and-using-transaction-ids">Defining and Using
Transaction IDs</h3>
<blockquote>
<p>Each transaction is uniquely identified by its Transaction ID. This
ID must be specified in the <em>TransID</em> field of any of the SAP PDU
the SAP client uses to activate and manage the transaction.</p>
<p>The Transaction ID is a ULONG[2] whose format and contents may be
freely defined by the SAP client, providing it:</p>
</blockquote>
<ul>
<li><p>Uniquely identifies each transaction of those executed by the SAP
client?SIA: giusto? on the same trading day.</p></li>
<li><p>The value of the Transaction ID used for a transaction executed
at a given time of the day is less than the value of the Transaction ID
of any transaction executed at a later time.</p></li>
</ul>
<blockquote>
<p>A possible application may, for example, be to enter a timestamp in
the first field and, in the second field, a progressive number which the
SAP client can reset during its initialization phase.</p>
</blockquote>
<h2 id="managing-subscriptions">Managing Subscriptions</h2>
<blockquote>
<p>A subscription to a market class enables a trader to receive
notifications of the changes that take place on the records of this
class.</p>
<p>Whenever a change takes place in any of the records in one of its
classes, the server broadcasts a message containing the image of the
record that has been changed to all the subscriptions active on that
class. </p>
<p>Figure 13 illustrates the exchange of PDUs that takes place during
the life of a subscription.</p>
</blockquote>
<figure>
<img src="media/image13.wmf" style="width:6.20833in;height:4.05208in" />
<figcaption><blockquote>
<p><strong>Figure 13.</strong> Exchange of PDUs and Messages during the
Life of a Subscription</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>By specifying a filter instance in a subscription to a given class, a
trader may receive only the records satisfying the specified criteria.
The relevant SMP documentation describes which filters are available for
each class and the values that may be specified.</p>
</blockquote>
<h3 id="subscription-types">Subscription Types</h3>
<blockquote>
<p>represents the behavior of a subscription depending on its type
(<em>SubscribeType</em> field of the
<strong>SAPSubscribeStartReq</strong> PDU).</p>
</blockquote>
<figure>
<img src="media/image14.wmf" style="width:3.29167in;height:2.65625in" />
<figcaption><blockquote>
<p><strong>Figure 14.</strong> Subscription Types</p>
</blockquote></figcaption>
</figure>
<blockquote>
<p>In addition to other constraints that may be set using filters, the
subscription type determines which of the records in a class the client
wishes to receive from the server. The subscription type also determines
who is to stop the subscription (either the client or the server).</p>
</blockquote>
<h6 id="subscription-type-all">Subscription Type = ALL</h6>
<blockquote>
<p>To direct the server to notify all records in a data class having
timestamp greater than, or equal to, a specified timestamp, the client
must start a subscription of type <strong>ALL</strong>.</p>
<p>The <em>StartTS</em> field the <strong>SAPSubscribeStartReq</strong>
PDU allows the client to specify from which record the server must start
sending notifications:</p>
</blockquote>
<ul>
<li><p>If <em>StartTS</em> = 0, the server will start from the record
having the oldest timestamp.</p></li>
<li><p>If <em>StartTS</em> specifies a given timestamp (corresponding to
any elapsed time on the current trade day), the server will start from
the first record having timestamp greater than, or equal to, the
specified timestamp.</p></li>
</ul>
<blockquote>
<p>The server continues notifying the class records to the client until
it receives a <strong>SAPSubscribeStopReq</strong> PDU from the client
or the market is closed.</p>
<p>When receiving the <strong>SAPSubscribeStopReq</strong> PDU, the
server replies with the <strong>SAPSubscribeStopRes</strong> PDU (thus
deallocating the related resources) only after having notified the
client of all class records with timestamp less than, or equal to, the
timestamp corresponding to the time when the
<strong>SAPSubscribeStopReq</strong> PDU was received.</p>
</blockquote>
<h6 id="subscription-type-stop">Subscription Type = STOP</h6>
<blockquote>
<p>To direct the server to notify all records in a data class having
timestamp less than, or equal to, the timestamp corresponding to the
time when the <strong>SAPSubscribeStartReq</strong> PDU is received by
the server, the client must start a subscription of type
<strong>STOP</strong>.</p>
<p>The <em>StartTS</em> field allows the client to specify from which
record the server must start sending notifications:</p>
</blockquote>
<ul>
<li><p>If <em>StartTS</em> = 0, the server will start from the record
having the oldest timestamp.</p></li>
<li><p>If <em>StartTS</em> specifies a given timestamp (corresponding to
any elapsed time on the current trade day), the server will start from
the first record having timestamp greater than, or equal to, the
specified timestamp.</p></li>
</ul>
<blockquote>
<p>After having sent the last record, the server sends a
<strong>SAPSubscribeIdle</strong> PDU to the client and deallocates the
local resources (the subscription is implicitly stopped as it no longer
exists). By receiving the <strong>SAPSubscribeIdle</strong> PDU, the
client knows that all requested records have been received and that the
subscription has been already stopped. Therefore, the client must simply
deallocate the local resources used for the subscription without having
to send the <strong>SAPSubscribeStopReq</strong> PDU.</p>
</blockquote>
<h6 id="subscription-type-ontime">Subscription Type = ONTIME</h6>
<blockquote>
<p>To direct the server to notify all records in a data class having
timestamp greater than the timestamp corresponding to the time when the
<strong>SAPSubscribeStartReq</strong> PDU is received by the server, the
client must start a subscription of type <strong>ONTIME</strong> (the
<em>StartTS</em> field is not significant in this case).</p>
<p>The server continues notifying the class records to the client until
it receives a <strong>SAPSubscribeStopReq</strong> PDU from the client
or the market is closed.</p>
<p>When receiving the <strong>SAPSubscribeStopReq</strong> PDU, the
server replies with the <strong>SAPSubscribeStopRes</strong> PDU (thus
deallocating the related resources) only after having notified the
client of all class records with timestamp less than, or equal to, the
timestamp corresponding to the time when the
<strong>SAPSubscribeStopReq</strong> PDU was received.</p>
</blockquote>
<h3 id="subscription-filters">Subscription Filters</h3>
<blockquote>
<p>A filter instance may be specified in the <em>FilterKey</em> field of
the <strong>SAPSubscribeStartReq</strong> PDU when a subscription is
started to reduce the set of records that the client wants to receive by
means of this subscription from those made available by a data
class.</p>
<p>For example, use the MTS_MARKET_SECTION_Filter filter made up of the
<em>MarketId</em> and <em>SectionId</em> fields of the MTS_MARKET_PARAMS
class to get the basic trading parameters, such as the market depth
length, for a specified section of a specified market.</p>
<p>A client cannot define filters, but can instanciate those defined by
the data class to which he wants to subscribe (not all data classes
support the filtering function or define filters). For a description of
the filters supported by each data class, see the corresponding SMP
documentation of the market to which the class belongs.</p>
<p>The SAP protocol provides the PDUs for creating and destroying a
filter instance and for assigning values to it.</p>
<p>The value assigned to a filter instance may be modified at any time,
regardless of whether any subscriptions are using it or not. However,
the change will only take effect on the records of the class that have
not yet been notified to the client.</p>
<p>It is not allowed to destroy a filter instance if it is being used by
at least one subscription.</p>
</blockquote>
<h2 id="managing-queries">Managing Queries</h2>
<blockquote>
<p>A query is used to request a data class for a finite set of data
records belonging to that class.</p>
<p>Each SMP class defines a predefined set of queries that can be used
by a client (clients are not allowed to define queries). For a
description of the queries supported by each data class, see the
corresponding SMP documentation of the market to which the class
belongs.</p>
<p>In addition, the SAP protocol provides clients with PDUs that may be
used to request the execution of a query and to obtain the data records
in the corresponding result-set.</p>
<p>For example, a class containing the trades concluded by a given
member could make available a query allowing clients to retrieve the
trades concluded by the member in a specified period.</p>
<p>When he submits a query (<strong>SAPQueryReq</strong> PDU), the
client may indicate whether he wants a paginated result or not.</p>
<p>If the result is paginated, the client must request the data of the
result-set of the query (<strong>SAPQueryRowsDataReq</strong> PDU) by
specifying the initial line and the number of lines in the result-set
requested. The client will receive one <strong>SAPQueryRowsData</strong>
PDU for each line requested.</p>
<p>The server retains the result-set for a specified time
(<strong>SAPQueryReq</strong> PDU), so the client can request the data
in the result-set (<strong>SAPQueryRowsDataReq</strong> PDU) several
times.</p>
<p>If the client does not request data for a time longer than the time
for which the data in the result-set are retained, the server closes the
query, notifies the client (<strong>SAPQueryRowsEnd</strong> PDU) and
deletes the data in the result-set.</p>
<p>If the result-set is not paginated, the client will receive all the
lines of the result-set (<strong>SAPQueryRowsData</strong> PDU) in
sequence without requesting them.</p>
<p>To request to close a query, the client sends the
<strong>SAPQueryDestroyReq</strong> PDU to the server. The server
replies with the <strong>SAPQueryDestroyRes</strong> PDU and sends a
<strong>SAPQueryRowsEnd</strong> PDU to indicate the end of transmission
of the data for that query.</p>
</blockquote>
<h2 id="sap-server-automaton"><br />
SAP Server Automaton</h2>
<blockquote>
<p>Figure 15 illustrates the finite-status automaton that controls the
operation of a SAP server.</p>
<p><strong>Figure 15.</strong> SAP Server Automaton</p>
</blockquote>
<h2 id="sap-client-automaton"><br />
SAP Client Automaton</h2>
<blockquote>
<p>Figure 16 illustrates the finite-status automaton that controls the
operation of a SAP client.</p>
<p><strong>Figure 16.</strong> SAP Client Automaton</p>
</blockquote>
<h1 id="section-3"></h1>
<h1 id="sap-pdu-reference">SAP PDU Reference</h1>
<blockquote>
<p>The format of the PDUs belonging to the SAP protocol is specified in
this chapter.</p>
</blockquote>
<h2 id="transport-addresses-management-pdus"><br />
Transport Addresses Management PDUs</h2>
<h3 id="sapaddressservicereq">SAPAddressServiceReq</h3>
<blockquote>
<p>The <strong>SAPAddressServiceReq</strong> PDU is sent by the SAP
client to the SAP Server to ask for the IP address and TCP port assigned
to each of the TradeImpact service available to the member on a single
platform/market on which the member is enabled, in case of “IP SP –
single platform”. This PDU can only be sent on an SSP Session involving
the IP_Request TradeImpact service.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 227.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPAddressServiceRes</strong> PDU.</td>
</tr>
</tbody>
</table>
<h3 id="sapaddressserviceres">SAPAddressServiceRes</h3>
<blockquote>
<p>The <strong>SAPAddressServiceRes</strong> PDU is the response to the
<strong>SAPAddressServiceReq</strong> PDU.</p>
<p>The <strong>SAPAddressServiceRes</strong> PDU is sent by the SAP
Server to the SAP client to notify the IP address and TCP port to which
connect, for each available service provided by the platform.</p>
<p>In this PDU, the three fields Service, Address and Port are repeated
20 times; therefore, a client may connect to a maximum of 20 TradeImpact
services. The three fields in a triplet may specify identifier, IP
address and TCP port of a service, or the values 0, 0, 0 (that is, no
service information specified by this triplet).</p>
<p><strong>Note</strong></p>
<p>In case of “IP SP – single platform”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN_INFO_PRIV.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 228</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPAddressServiceReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_AddrServiceOK</p>
<p>1 – SAP_AddrServiceBAD (formal error in the SAPAddressServiceReq
PDU)</p></td>
</tr>
<tr>
<td>Service</td>
<td>ENUM</td>
<td><p>Service identifier, as follows:</p>
<p>0 – IP_Request (addresses not distributed)</p>
<p>1 – TXN</p>
<p>2 – INFO_BRT</p>
<p>3 – INFO_PRIV</p>
<p>4 – TXN_INFO_PRIV</p>
<p>5 – DATA_FEED</p>
<p>6 – PRESS</p>
<p>7 – RECOVERY_ INFO_BRT</p>
<p>8 – RECOVERY_ INFO_PRIV</p>
<p>9 – RECOVERY_ DATA_FEED</p>
<p>10 – RECOVERY_ PRESS</p>
<p>11 – RECOVERY_ALL</p>
<p>99 – ALL</p></td>
</tr>
<tr>
<td>Address</td>
<td>STRING[16]</td>
<td>Service IP address in format xxx.xxx.xxx.xxx or service logical
name</td>
</tr>
<tr>
<td>Port</td>
<td>ULONG</td>
<td>Service TCP port number</td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Service</td>
<td>ENUM</td>
<td><p>0 – IP_Request (not distributed)</p>
<p>1 – TXN</p>
<p>…………..</p>
<p>99 – ALL</p></td>
</tr>
<tr>
<td>Address</td>
<td>STRING[16]</td>
<td>Service address in format xxx.xxx.xxx.xxx or service logical
name</td>
</tr>
<tr>
<td>Port</td>
<td>ULONG</td>
<td>Service port</td>
</tr>
</tbody>
</table>
<h3 id="sapaddressservicereqext">SAPAddressServiceReqExt</h3>
<blockquote>
<p>The <strong>SAPAddressServiceReqExt</strong> PDU is sent by the SAP
client to the SAP Server to ask for the IP address and TCP port assigned
to each of the TradeImpact service available to the member, on all
platforms/markets on which the member is enabled, in case of “IP SP –
centralized”. This PDU can only be sent on an SSP Session involving the
IP_Request TradeImpact service.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 252.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPAddressServiceResExt</strong> PDU.</td>
</tr>
</tbody>
</table>
<h3 id="sapaddressserviceresext">SAPAddressServiceResExt</h3>
<blockquote>
<p>The <strong>SAPAddressServiceResExt</strong> PDU is the response to
the <strong>SAPAddressServiceReqExt</strong> PDU.</p>
<p>The <strong>SAPAddressServiceResExt</strong> PDU is sent by the SAP
Server to the SAP client to notify the IP address and TCP port to which
connect, for each available service provided by each platform.</p>
</blockquote>
<p>In this PDU, the SAPPlatformServices substructure is repeated 20
times. Each SAPPlatformServices substructure specifies, for each
platform, up to 10 combinations of &lt;service, IP address, TCP
port&gt;.</p>
<blockquote>
<p>Therefore a client can connect to a maximum of 10 TradeImpact
services for each market.</p>
<p>The three fields in a triplet may specify identifier, IP address and
TCP port of a service, or the values 0, 0, 0 (that is, no service
information specified by this triplet).</p>
<p><strong>Note</strong></p>
<p>In case of “IP SP – centralized”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN, TXN_INFO_PRIV, DATAFEED,
QUERY.</p>
<p>The list of services available on the various MTS platforms is given
in paragraph “<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>”.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 25%" />
<col style="width: 48%" />
</colgroup>
<thead>
<tr>
<th>FIELD</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 253</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPAddressServiceReqExt</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_AddrServiceOK</p>
<p>1 – SAP_AddrServiceBAD (formal error in the SAPAddressServiceReq
PDU)</p></td>
</tr>
<tr>
<td>PlatformServices</td>
<td><p>STRUCT</p>
<p><a
href="#sapplatformservices-substructure">SAPPlatformServices</a>[20]</p></td>
<td></td>
</tr>
</tbody>
</table>
<h6 id="sapplatformservices-substructure">SAPPlatformServices
Substructure</h6>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>PlatformId</td>
<td>ULONG</td>
<td><p>Platform identifier, as follows:</p>
<p>2 – MTS_PAF (PAF Market)</p>
<p>3 – MTS_CMF (CMF Market)</p>
<p>4 – MTS_MMF2 (RTF e SMF Markets)</p>
<p>5 – MTS_STF (STF Market)</p>
<p>6 – MTS_BV (BV Market)</p></td>
</tr>
<tr>
<td>AddressServices</td>
<td><p>STRUCT</p>
<p><a
href="#sapaddressservices-substructure">SAPAddressServices</a>[10]</p></td>
<td></td>
</tr>
</tbody>
</table>
<h6 id="sapaddressservices-substructure">SAPAddressServices
Substructure</h6>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>Service</td>
<td>ENUM</td>
<td><p>Service identifier, as follows:</p>
<p>0 – IP_Request (addresses not distributed)</p>
<p>1 – TXN</p>
<p>2 – INFO_BRT</p>
<p>3 – INFO_PRIV</p>
<p>4 – TXN_INFO_PRIV</p>
<p>5 – DATA_FEED</p>
<p>6 – QUERY</p>
<p>7 – RECOVERY_INFO_BRT</p>
<p>8 – RECOVERY_INFO_PRIV</p>
<p>9 – RECOVERY_ DATA_FEED</p>
<p>10 – RECOVERY_ PRESS</p>
<p>11 – RECOVERY_ALL</p>
<p>99 – ALL</p></td>
</tr>
<tr>
<td>Address</td>
<td>STRING[16]</td>
<td><p>Service address in format xxx.xxx.xxx.xxx,</p>
<p>or service logical name</p></td>
</tr>
<tr>
<td>Port</td>
<td>ULONG</td>
<td>Service TCP port number</td>
</tr>
</tbody>
</table>
<h2 id="logonlogoff-pdus"><br />
Logon/Logoff PDUs</h2>
<h3 id="saplogonreq">SAPLogonReq</h3>
<blockquote>
<p>The <strong>SAPLogonReq</strong> PDU is sent by the SAP client to the
SAP Server to deliver the logon request of a trader to the TradeImpact
service involved in the SSP session.</p>
<p><strong>Note</strong></p>
<p>In case of “IP SP – single platform”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN_INFO_PRIV.</p>
<p>In case of “IP SP – centralized”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN, TXN_INFO_PRIV, DATAFEED,
QUERY.</p>
<p>The list of services available on the various MTS platforms is given
in paragraph “<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>”.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 16%" />
<col style="width: 57%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 201.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related <strong>SAPLogonRes</strong>
PDU.</td>
</tr>
<tr>
<td>ProtocolRevision</td>
<td>ULONG</td>
<td><p>Version of the SAP protocol supported by the SAP client</p>
<p>0 – indicates that the SAP client accepts the protocol version
specified by the SAP server in the SAPLogonRes PDU</p></td>
</tr>
<tr>
<td>Signature</td>
<td>ULONG</td>
<td>Signature of the requesting client.</td>
</tr>
<tr>
<td>Service</td>
<td>ENUM</td>
<td><p>Service identifier, as follows:</p>
<p>0 – IP_Request (addresses not distributed)</p>
<p>1 – TXN</p>
<p>2 – INFO_BRT</p>
<p>3 – INFO_PRIV</p>
<p>4 – TXN_INFO_PRIV</p>
<p>5 – DATA_FEED</p>
<p>6 – QUERY</p>
<p>7 – RECOVERY_INFO_BRT</p>
<p>8 – RECOVERY_INFO_PRIV</p>
<p>9 – RECOVERY_ DATA_FEED</p>
<p>10 – RECOVERY_ PRESS</p>
<p>11 – RECOVERY_ALL</p>
<p>99 – ALL</p></td>
</tr>
<tr>
<td>SoftwareRevision</td>
<td>ULONG</td>
<td>Version of client</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name (format: “tradername@membername”).</td>
</tr>
<tr>
<td>Password</td>
<td>STRING[32]</td>
<td>Password associated with the trader.</td>
</tr>
<tr>
<td>NewPassword</td>
<td>STRING[32]</td>
<td><p>New password (optional). If a valid password is specified, it is
enabled immediately.</p>
<p>For details, see "" on page .</p></td>
</tr>
</tbody>
</table>
<h3 id="saplogonres">SAPLogonRes</h3>
<blockquote>
<p>The <strong>SAPLogonRes</strong> PDU is sent by the SAP Server to the
SAP client in response to a <strong>SAPLogonReq</strong> PDU to indicate
the outcome of a logon request.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 202.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPLogonReq</strong> PDU.</td>
</tr>
<tr>
<td>ProtocolRevision</td>
<td>ULONG</td>
<td>Version of the SAP protocol supported by the SAP server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>Logon request result. Any of the following values:</p>
<p>0 – LoginOK</p>
<p>1 – LoginInvalPWD</p>
<p>2 – LoginInvalUSR</p>
<p>3 – LoginInvalVER</p>
<p>4 – LoginALREADYLOG</p>
<p>5 – LoginInternalError</p>
<p>6 – AccountNotActive</p>
<p>7 – TooManyTradersConnected</p>
<p>8 – Password Expired</p>
<p>9 – NotPrivilegeChangePassword</p>
<p>10 – NewPasswordRepeated</p>
<p>11 – Insufficient new password length</p>
<p>12 – Invalid new password characters</p>
<p>13 – New password too much easy</p>
<p>14 – Bad Certificate: User Mismatch (the CommonName set in the SSL
certificate does not match the trader’s name set in the UserName field
of the SAPLogonReq)</p>
<p>15 – Invalid or Unsupported Certificate (SSL)</p>
<p>16 - Service Unavailable</p></td>
</tr>
<tr>
<td>SoftwareRevision</td>
<td>ULONG</td>
<td>Version of the application services supported by the Server</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name (same as that specified in the
<strong>SAPLogonReq</strong> PDU)</td>
</tr>
<tr>
<td>PasswdLife</td>
<td>ULONG</td>
<td><p>Password life (in number of days).</p>
<p>A logon request sent when the password is expired, is rejected by the
Server (<em>Result</em> = 8). To set a new password, use the
<strong>SAPLogonReq</strong> PDU</p></td>
</tr>
<tr>
<td>SystemDate</td>
<td>ULONG</td>
<td>Date of the Front End system</td>
</tr>
<tr>
<td>SystemTime</td>
<td>ULONG</td>
<td>Time of the Front End system</td>
</tr>
</tbody>
</table>
<blockquote>

</blockquote>
<h3 id="saplogontokenreq"><br />
SAPLogonTokenReq</h3>
<blockquote>
<p>The <strong>SAPLogonTokenReq</strong> PDU is sent by the SAP client
to the SAP Server to deliver the logon request of a trader to the
TradeImpact service involved in the SSP session.</p>
<p><strong>Note</strong></p>
<p>In case of “IP SP – single platform”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN_INFO_PRIV.</p>
<p>In case of “IP SP – centralized”, TradeImpact implements the
following services: IP_Request, INFO_BRT, TXN, TXN_INFO_PRIV, DATAFEED,
QUERY.</p>
<p>The list of services available on the various MTS platforms is given
in paragraph “<a
href="#availability-of-ip-sp-modes-and-services-on-mts-platforms">Availability
of IP SP Modes and Services on MTS Platforms</a>”.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 250.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPLogonTokenRes</strong> PDU.</td>
</tr>
<tr>
<td>ProtocolRevision</td>
<td>ULONG</td>
<td><p>Version of the SAP protocol supported by the SAP client</p>
<p>0 – indicates that the SAP client accepts the protocol version
specified by the SAP server in the SAPLogonTokenRes PDU</p></td>
</tr>
<tr>
<td>Signature</td>
<td>ULONG</td>
<td>Signature of the requesting client.</td>
</tr>
<tr>
<td>Service</td>
<td>ENUM</td>
<td><p>Service identifier, as follows:</p>
<p>0 – IP_Request (addresses not distributed)</p>
<p>1 – TXN</p>
<p>2 – INFO_BRT</p>
<p>3 – INFO_PRIV</p>
<p>4 – TXN_INFO_PRIV</p>
<p>5 – DATA_FEED</p>
<p>6 – QUERY</p>
<p>7 – RECOVERY_INFO_BRT</p>
<p>8 – RECOVERY_INFO_PRIV</p>
<p>9 – RECOVERY_ DATA_FEED</p>
<p>10 – RECOVERY_ PRESS</p>
<p>11 – RECOVERY_ALL</p>
<p>99 – ALL</p></td>
</tr>
<tr>
<td>SoftwareRevision</td>
<td>ULONG</td>
<td>Version of client</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name (format: “tradername@membername”).</td>
</tr>
<tr>
<td>Password</td>
<td>STRING[32]</td>
<td>Password associated with the trader.</td>
</tr>
<tr>
<td>NewPassword</td>
<td>STRING[32]</td>
<td>New password (optional). If a valid password is specified, it is
enabled immediately.</td>
</tr>
</tbody>
</table>
<h3 id="saplogontokenres"><br />
SAPLogonTokenRes</h3>
<blockquote>
<p>The <strong>SAPLogonTokenRes</strong> PDU is sent by the SAP Server
to the SAP client in response to a <strong>SAPLogonTokenReq</strong> PDU
to indicate the outcome of a logon request.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 251.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPLogonTokenReq</strong> PDU.</td>
</tr>
<tr>
<td>ProtocolRevision</td>
<td>ULONG</td>
<td>Version of the SAP protocol supported by the SAP server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>Logon request result. Any of the following values:</p>
<p>0 – LoginOK</p>
<p>1 – LoginInvalPWD</p>
<p>2 – LoginInvalUSR</p>
<p>3 – LoginInvalVER</p>
<p>4 – LoginALREADYLOG</p>
<p>5 – LoginInternalError</p>
<p>6 – AccountNotActive</p>
<p>7 – TooManyTradersConnected</p>
<p>8 – Password Expired</p>
<p>9 – NotPrivilegeChangePassword</p>
<p>10 – NewPasswordRepeated</p>
<p>11 – Insufficient new password length</p>
<p>12 – Invalid new password characters</p>
<p>13 – New password too much easy</p>
<p>14 – Bad Certificate: User Mismatch (the CommonName set in the SSL
certificate does not match the trader’s name set in the UserName field
of the SAPLogonTokenReq)</p>
<p>15 – Invalid or Unsupported Certificate (SSL)</p>
<p>16 - Service Unavailable</p></td>
</tr>
<tr>
<td>SoftwareRevision</td>
<td>ULONG</td>
<td>Version of the application services supported by the Server</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name (same as that specified in the
<strong>SAPLogonTokenReq</strong> PDU)</td>
</tr>
<tr>
<td>PasswdLife</td>
<td>ULONG</td>
<td><p>Password life (in number of days).</p>
<p>A logon request sent when the password is expired, is rejected by the
Server (<em>Result</em> = 8). To set a new password, use the
<strong>SAPLogonTokenReq</strong> PDU</p></td>
</tr>
<tr>
<td>SystemDate</td>
<td>ULONG</td>
<td>Date of the Front End system</td>
</tr>
<tr>
<td>SystemTime</td>
<td>ULONG</td>
<td>Time of the Front End system</td>
</tr>
<tr>
<td>AuthorizationToken</td>
<td>STRING[32]</td>
<td><p>Authorization token to access MTS Ancillary System (MAS).</p>
<p>Specified only on TXN_INFO_PRIV service</p></td>
</tr>
</tbody>
</table>
<h3 id="saplogoffreq"><br />
SAPLogoffReq</h3>
<blockquote>
<p>The <strong>SAPLogoffReq</strong> PDU is sent by the SAP client to
the SAP Server to deliver a logoff request of a trader from the
TradeImpact service involved in the SSP session.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 203.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related <strong>SAPLogoffRes</strong>
PDU.</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name.</td>
</tr>
</tbody>
</table>
<h3 id="saplogoffres">SAPLogoffRes</h3>
<blockquote>
<p>The <strong>SAPLogoffRes</strong> PDU is sent by the SAP Server to
the SAP client in response to a <strong>SAPLogoffReq</strong> PDU to
indicate the result of a logoff request.</p>
<p>The activation of a logoff entails closing the services still active
for the trader specified.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 204.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPLogoffReq</strong> PDU</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – LogoffOK</p>
<p>1 – LogoffBAD</p></td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>The fully qualified trader name as that specified by the SAP client
in the <strong>SAPLogoffReq</strong> PDU</td>
</tr>
</tbody>
</table>
<blockquote>

</blockquote>
<h2 id="password-management-pdus"><br />
Password Management PDUs</h2>
<h3 id="sapchangepasswordreq">SAPChangePasswordReq</h3>
<blockquote>
<p>The <strong>SAPChangePasswordReq</strong> PDU is sent by the SAP
client to the SAP Server to deliver a request to change the password of
a trader.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 205</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPChangePasswordRes</strong> PDU.</td>
</tr>
<tr>
<td>UserName</td>
<td>STRING[32]</td>
<td>Fully qualified trader name (format “tradername@membername”.</td>
</tr>
<tr>
<td>OldPassword</td>
<td>STRING[32]</td>
<td>Current password associated with the trader.</td>
</tr>
<tr>
<td>NewPassword</td>
<td>STRING[32]</td>
<td><p>New password to be associated with the trader.</p>
<p>For details, see "" on page .</p></td>
</tr>
</tbody>
</table>
<h3 id="sapchangepasswordres">SAPChangePasswordRes</h3>
<blockquote>
<p>The <strong>SAPChangePasswordRes</strong> PDU is sent by the SAP
Server to the SAP client in response to a
<strong>SAPChangePasswordReq</strong> PDU to indicate the result of a
request to change password.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 206.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPChangePasswordReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – ChangePasswordOK</p>
<p>1 – NoPrivilege</p>
<p>2 – InvalidOldPassword</p>
<p>3 – InvalidUserName</p>
<p>4 – NotPrivilegeChangePassword</p>
<p>5 – NewPasswordRepeated</p>
<p>6 – Insufficient new password length</p>
<p>7 – Invalid new password characters</p>
<p>8 – New password too much easy</p></td>
</tr>
</tbody>
</table>
<h2 id="class-actions-pdus"><br />
Class Actions PDUs</h2>
<blockquote>
<p>Class Actions PDUs are provided in three formats, which differ for
the information about the time spent by the Central System to work out
the request, as described in chapter “<a
href="#executing-actions-on-a-class">Executing Actions on a
Class</a>”.</p>
<p>The layout of the various PDUs is described below.</p>
</blockquote>
<h3 id="sapextactionreq">SAPExtActionReq</h3>
<blockquote>
<p>The <strong>SAPExtActionReq</strong> PDU is sent by the SAP client to
the SAP Server to deliver the request to perform an action on the
specified class.</p>
<p>The SAP Server will reply to the <strong>SAPExtActionReq</strong> PDU
with a <strong>SAPExtActionRes</strong> PDU providing timestamps with
microsecond resolution, which the SAP Client can use to calculate the
overall transaction elapsed time.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 217.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPExtActionRes</strong> PDU.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class to which the request for action is addressed
(see SMP protocol)</td>
</tr>
<tr>
<td>KeyID</td>
<td>ULONG</td>
<td>Key ID used by the SAP client to identify the record uniquely</td>
</tr>
<tr>
<td>Action</td>
<td>ENUM</td>
<td><p>0 – ADD (addition of a new record)</p>
<p>1 – DEL (logical deletion of an existing record)</p>
<p>2 – RWT (updating of an existing record)</p>
<p>3 – KILL (permanent deletion of a record from the DB)</p></td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day</td>
</tr>
<tr>
<td>DataInResponse</td>
<td>BOOLEAN</td>
<td><p>Flag indicating whether the <strong>SAPExtActionRes</strong> PDU
must also return the SMP data record generated by the transaction.
Possible values are:</p>
<p>0 – The <strong>SAPExtActionRes</strong> PDU must return the SMP data
record generated by the transaction.</p>
<p>1 – The <strong>SAPExtActionRes</strong> PDU must not return the SMP
data record.</p>
<p>This flag is only significant if the <em>Data Notification</em>
attribute of the class to which the action request was sent is set to
SUBSCRIPTION_RESPONSE or RESPONSE).</p></td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Transparent data for the Application layer and belonging to the
market layer</td>
</tr>
</tbody>
</table>
<h3 id="sapextactionres"><br />
SAPExtActionRes</h3>
<blockquote>
<p>The <strong>SAPExtActionRes</strong> PDU is sent by the SAP Server to
the SAP client in response to a <strong>SAPExtActionReq</strong> PDU to
notify the creation of the corresponding transaction in the market.</p>
<p>The <strong>SAPExtActionRes</strong> PDU returns two timestamps, with
microsecond resolution, taken by the SAP Server to the SAP Client:
<em>InTimestamp</em> and <em>OutTimestamp</em>. The difference
(<em>OutTimestamp</em> - <em>InTimestamp</em>) is the time spent by the
TradeImpact Server to fulfill the action request.</p>
<p>This PDU can contain the application data (if requested in the
<strong>SAPExtActionReq</strong> PDU and supported by the market).</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 218.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPExtActionReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_TransOK</p>
<p>1 – SAP_TransKO</p>
<p>2 – SAP_TransInvalidTID</p></td>
</tr>
<tr>
<td>ReasonCode</td>
<td>LONG</td>
<td>Associated error code (SMP layer)</td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day. Entered by the client in
the corresponding <strong>SAPExtActionReq</strong> PDU</td>
</tr>
<tr>
<td>InTimestamp</td>
<td>UTIME</td>
<td>Timestamp (expressed as hmmssmmm<strong>uuu</strong>) of the time
when the SAP Server has received the corresponding
<strong>SAPExtActionReq</strong> PDU from the access connection that
interconnects it with the SAP Client sender of the action request.</td>
</tr>
<tr>
<td>OutTimestamp</td>
<td>UTIME</td>
<td>Timestamp (expressed as hmmssmmm<strong>uuu</strong>) of the time
when the SAP Server has sent this <strong>SAPExtActionRes</strong> PDU
on the access connection that interconnects it with the SAP Client
sender of the action request.</td>
</tr>
<tr>
<td>ResClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class contained in the Data field (if 0
<em>Data</em> field not present)</td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Data transparent for the Application layer and belonging to the
Market layer (Optional)</td>
</tr>
</tbody>
</table>
<h3 id="sapmonitoredactionreq"><br />
SAPMonitoredActionReq</h3>
<blockquote>
<p>The <strong>SAPActionMonitoredReq</strong> PDU is sent by the SAP
client to the SAP Server to deliver the request to perform an action on
the specified class.</p>
<p>The SAP Server will reply to the
<strong>SAPActionMonitoredReq</strong> PDU with a
<strong>SAPActionMonitoredRes</strong> PDU carrying two timestamps with
milliseconds resolution, which the SAP Client can use to calculate the
overall transaction elapse time.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 215.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPMonitoredActionRes</strong> PDU.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class to which the request for action is addressed
(see SMP protocol)</td>
</tr>
<tr>
<td>KeyID</td>
<td>ULONG</td>
<td>Key ID used by the SAP client to identify the record uniquely</td>
</tr>
<tr>
<td>Action</td>
<td>ENUM</td>
<td><p>0 – ADD (addition of a new record)</p>
<p>1 – DEL (logical deletion of an existing record)</p>
<p>2 – RWT (updating of an existing record)</p>
<p>3 – KILL (permanent deletion of a record from the DB)</p></td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day</td>
</tr>
<tr>
<td>DataInResponse</td>
<td>BOOLEAN</td>
<td><p>Flag indicating whether the
<strong>SAPMonitoredActionRes</strong> PDU must also return the SMP data
record generated by the transaction. Possible values are:</p>
<p>0 – The <strong>SAPMonitoredActionRes</strong> PDU must return the
SMP data record generated by the transaction.</p>
<p>1 – The <strong>SAPMonitoredActionRes</strong> PDU must not return
the SMP data record.</p>
<p>This flag is only significant if the <em>Data Notification</em>
attribute of the class to which the action request was sent is set to
SUBSCRIPTION_RESPONSE or RESPONSE).</p></td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Transparent data for the Application layer and belonging to the
market layer</td>
</tr>
</tbody>
</table>
<h3 id="sapmonitoredactionres"><br />
SAPMonitoredActionRes</h3>
<blockquote>
<p>The <strong>SAPMonitoredActionRes</strong> PDU is sent by the SAP
Server to the SAP client in response to a
<strong>SAPMonitoredActionReq</strong> PDU to notify the creation of the
corresponding transaction in the market.</p>
<p>The <strong>SAPMonitoredActionRes</strong> PDU returns two
timestamps, with milliseconds resolution, taken by the SAP Server to the
SAP Client: <em>InTimestamp</em> and <em>OutTimestamp</em>. The
difference (<em>OutTimestamp</em> - <em>InTimestamp</em>) is the time
spent by the TradeImpact Server to fulfill the action request.</p>
<p>This PDU can contain the application data (if requested in the
<strong>SAPMonitoredActionReq</strong> PDU and supported by the
market).</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 216.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPMonitoredActionReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_TransOK</p>
<p>1 – SAP_TransKO</p>
<p>2 – SAP_TransInvalidTID</p></td>
</tr>
<tr>
<td>ReasonCode</td>
<td>LONG</td>
<td>Associated error code (SMP layer)</td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day. Entered by the client in
the corresponding <strong>SAPMonitoredActionReq</strong> PDU</td>
</tr>
<tr>
<td>InTimestamp</td>
<td>ULONG</td>
<td>Timestamp (expressed as hmmssmmm) of the time when the SAP Server
has received the corresponding <strong>SAPMonitoredActionReq</strong>
PDU from the access connection that interconnects it with the SAP Client
sender of the action request.</td>
</tr>
<tr>
<td>OutTimestamp</td>
<td>ULONG</td>
<td>Timestamp (expressed as hmmssmmm) of the time when the SAP Server
has sent this <strong>SAPMonitoredActionRes</strong> PDU on the access
connection that interconnects it with the SAP Client sender of the
action request.</td>
</tr>
<tr>
<td>ResClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class contained in the Data field (if 0
<em>Data</em> field not present)</td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Data transparent for the Application layer and belonging to the
Market layer (Optional)</td>
</tr>
</tbody>
</table>
<h3 id="sapactionreq"><br />
SAPActionReq</h3>
<blockquote>
<p>The <strong>SAPActionReq</strong> PDU is sent by the SAP client to
the SAP Server to deliver the request to perform an action on the
specified class.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 210.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related <strong>SAPActionRes</strong>
PDU.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class to which the request for action is addressed
(see SMP protocol)</td>
</tr>
<tr>
<td>KeyID</td>
<td>ULONG</td>
<td>Key ID used by the SAP client to identify the record uniquely</td>
</tr>
<tr>
<td>Action</td>
<td>ENUM</td>
<td><p>0 – ADD (addition of a new record)</p>
<p>1 – DEL (logical deletion of an existing record)</p>
<p>2 – RWT (updating of an existing record)</p>
<p>3 – KILL (permanent deletion of a record from the DB)</p></td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day</td>
</tr>
<tr>
<td>DataInResponse</td>
<td>BOOLEAN</td>
<td><p>Flag indicating whether the <strong>SAPActionRes</strong> PDU
must also return the SMP data record generated by the transaction.
Possible values are:</p>
<p>0 – The <strong>SAPActionRes</strong> PDU must return the SMP data
record generated by the transaction.</p>
<p>1 – The <strong>SAPActionRes</strong> PDU must not return the SMP
data record.</p>
<p>This flag is only significant if the <em>Data Notification</em>
attribute of the class to which the action request was sent is set to
SUBSCRIPTION_RESPONSE or RESPONSE).</p></td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Transparent data for the Application layer and belonging to the
market layer</td>
</tr>
</tbody>
</table>
<h3 id="sapactionres">SAPActionRes</h3>
<blockquote>
<p>The <strong>SAPActionRes</strong> PDU is sent by the SAP Server to
the SAP client in response to a <strong>SAPActionReq</strong> PDU to
notify the creation of the corresponding transaction in the market.</p>
<p>This PDU can contain the application data (if requested in the
<strong>SAPActionReq</strong> PDU and supported by the market).</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 211.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPActionReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_TransOK</p>
<p>1 – SAP_TransKO</p>
<p>2 – SAP_TransInvalidTID</p></td>
</tr>
<tr>
<td>ReasonCode</td>
<td>LONG</td>
<td>Associated error code (SMP layer)</td>
</tr>
<tr>
<td>TransID</td>
<td>ULONG[2]</td>
<td>Unique progressive number for market day. Entered by the client in
the corresponding <strong>SAPActionReq</strong> PDU</td>
</tr>
<tr>
<td>ResClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class contained in the Data field (if 0
<em>Data</em> field not present)</td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Data transparent for the Application layer and belonging to the
Market layer (Optional)</td>
</tr>
</tbody>
</table>
<blockquote>

</blockquote>
<h2 id="section-4"><br />
</h2>
<h2 id="sap-error-notification-pdus">SAP Error Notification PDUs</h2>
<h3 id="saperrormsg">SAPErrorMsg</h3>
<blockquote>
<p>The <strong>SAPErrorMsg</strong> PDU is sent by the SAP client or the
SAP server to notify an error.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 214.</td>
</tr>
<tr>
<td>ErrorCode</td>
<td>ENUM</td>
<td>Error code</td>
</tr>
<tr>
<td>ErrorString</td>
<td>STRING[1024]</td>
<td>Description of error</td>
</tr>
</tbody>
</table>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>ERROR CODE</td>
<td>ERROR TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>1</td>
<td>InvalidRequest</td>
<td>Invalid MessageType</td>
</tr>
</tbody>
</table>
<h2 id="subscription-pdus"><br />
Subscription PDUs</h2>
<h3 id="sapsubscribestartreq">SAPSubscribeStartReq</h3>
<blockquote>
<p>The <strong>SAPSubscribeStartReq</strong> PDU is sent by the SAP
client to the SAP Server to deliver a request to start a subscription to
the class specified in the <em>ClassID</em> field.</p>
<p>Used to specify a filter.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 220.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPSubscribeStartRes</strong> PDU.</td>
</tr>
<tr>
<td>SubscribeType</td>
<td>ENUM</td>
<td><p>0 – ALL</p>
<p>1 – STOP</p>
<p>2 – ONTIME</p></td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class to which the subscription request is
addressed (see SMP protocol)</td>
</tr>
<tr>
<td>ClassVer</td>
<td>ULONG</td>
<td><p>Version of the class in the SAP client’s possession</p>
<p>0 – request to adapt to the current version of the class on the SAP
server</p></td>
</tr>
<tr>
<td>StartTS</td>
<td>ULONG[2]</td>
<td><p>Timestamp that determines which is the first record that is to be
notified, or 0 to force the Server to start from the first record in the
class.</p>
<p>The <em>SubscribeType</em> field determines how this field is
used.</p></td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Unique ID of a filter (0 = no filter)</td>
</tr>
</tbody>
</table>
<h3 id="sapsubscribestartres">SAPSubscribeStartRes</h3>
<blockquote>
<p>The <strong>SAPSubscribeStartRes</strong> PDU is sent by the SAP
Server to the SAP client in response to a
<strong>SAPSubscribeStartReq</strong> PDU to indicate whether the
request to subscribe to the specified class has been accepted or
rejected.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 221.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPSubscribeStartReq</strong> PDU.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class to which the subscription request is
addressed (see SMP protocol)</td>
</tr>
<tr>
<td>ClassVer</td>
<td>ULONG</td>
<td>Version of the class in use on the SAP server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_SubscribeOK</p>
<p>1 – SAP_SubscribeKO (insufficient rights)</p>
<p>2 – SAP_SubscribeBAD (formal error in the
<strong>SAPSubscribeStartReq</strong> PDU)</p>
<p>3 – SAP_SubscribeInvalidFilterID</p>
<p>4 – Reserved for future use</p>
<p>5 – SAP_SubscribeTooManySubscriptionsOpen</p>
<p>6 – SAP_SubscribeNoFilterSpecified</p></td>
</tr>
<tr>
<td>ResetClass</td>
<td>BOOLEAN</td>
<td><p>0 – version specified by the SAP client the same as the one on
the SAP server</p>
<p>1 – version specified by the SAP client different from the one on the
SAP server</p></td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Unique ID of a filter (0 = no filter)</td>
</tr>
<tr>
<td>SubscribeKey</td>
<td>ULONG</td>
<td>Unique ID associated by the SAP server with the subscription</td>
</tr>
</tbody>
</table>
<h3 id="sapsubscribestopreq">SAPSubscribeStopReq</h3>
<blockquote>
<p>The <strong>SAPSubscribeStopReq</strong> PDU is sent by the SAP
client to the SAP Server to deliver a request to stop a
subscription.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 222.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPSubscribeStopRes</strong> PDU.</td>
</tr>
<tr>
<td>SubscribeKey</td>
<td>ULONG</td>
<td>ID of the subscription returned with the
<strong>SAPSubscribeStartRes</strong> PDU</td>
</tr>
</tbody>
</table>
<h3 id="sapsubscribestopres">SAPSubscribeStopRes</h3>
<blockquote>
<p>The <strong>SAPSubscribeStopRes</strong> PDU is sent by the SAP
Server to the SAP client in response to a
<strong>SAPSubscribeStopReq</strong> PDU to indicate the result of the
request to stop a subscription.</p>
</blockquote>
<table style="width:98%;">
<colgroup>
<col style="width: 16%" />
<col style="width: 30%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 223.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPSubscribeStopReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_SubscribeOK</p>
<p>1 – SAP_SubscribeBAD (formal error in the
<strong>SAPSubscribeStoptReq</strong> PDU)</p></td>
</tr>
<tr>
<td>SubscribeKey</td>
<td>ULONG</td>
<td>ID of the subscription specified in the
<strong>SAPSubscribeStopReq</strong> PDU</td>
</tr>
</tbody>
</table>
<h3 id="sapsubscribedata"><br />
SAPSubscribeData</h3>
<blockquote>
<p>The <strong>SAPSubscribeData</strong> PDU is sent by the SAP Server
to the SAP client to deliver a notification coming from the
<em>ClassID</em> class.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 224.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class that created the notification (see SMP
protocol)</td>
</tr>
<tr>
<td>KeyID</td>
<td>ULONG</td>
<td>Key for uniquely identifying the record received (see SMP
protocol)</td>
</tr>
<tr>
<td>Action</td>
<td>ENUM</td>
<td><p>Action that caused a variation in the record</p>
<p>0 – ADD (new record added)</p>
<p>1 – DEL (record deleted logically)</p>
<p>2 – RWT (existing record updated)</p>
<p>3 – KILL (record deleted physically)</p></td>
</tr>
<tr>
<td>TimeStamp</td>
<td>ULONG[2]</td>
<td>TimeStamp associated with the current version contained in the
<em>Data</em> field. If <em>Action</em> is equal to KILL the first LONG
contains the class Version.</td>
</tr>
<tr>
<td>SubscribeKey</td>
<td>ULONG</td>
<td>Unique ID associated by the SAP server with the subscription</td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Data transparent for the Application layer and belonging to the
market layer</td>
</tr>
</tbody>
</table>
<h3 id="sapsubscribeidle">SAPSubscribeIdle</h3>
<blockquote>
<p>The <strong>SAPSubscribeIdle</strong> PDU is sent by the SAP Server
to the SAP client to indicate that the data is aligned (there are no
other variations).</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 225.</td>
</tr>
<tr>
<td>ClassID</td>
<td>ULONG</td>
<td>Numeric ID of the class (see SMP protocol)</td>
</tr>
<tr>
<td>SubscribeKey</td>
<td>ULONG</td>
<td>Unique ID associated by the SAP server with the subscription</td>
</tr>
</tbody>
</table>
<h3 id="filter-management-pdus"><br />
Filter Management PDUs</h3>
<h3 id="sapfiltercreatereq">SAPFilterCreateReq</h3>
<blockquote>
<p>The <strong>SAPFilterCreateReq</strong> PDU is sent by the SAP client
to the SAP Server to deliver a request to instanciate the specified
filter using the provided filter value.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 230.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPFilterCreateRes</strong> PDU.</td>
</tr>
<tr>
<td>FilterID</td>
<td>ULONG</td>
<td>The identifier of the filter definition.</td>
</tr>
<tr>
<td>FilterVal</td>
<td>STRING[<em><strong>8192</strong></em>]</td>
<td><p>Filter value. The set of rules that determine which of the
records in the class subscribed using this filter instance, are to be
notified to the client.</p>
<p><em><strong>The buffer length is 8 K.</strong></em></p></td>
</tr>
</tbody>
</table>
<h6 id="details-1">Details</h6>
<blockquote>
<p>The string in the <em>FilterVal</em> field is made up of one or more
filter rules, where each rule is separated from the next by a ";"
character. Rules are OR-ed, that is, a class record is only notified on
the subscription if it satisfies at least one of the filters rules.</p>
<p>A filter rule consists of 1 to up N rule values, where N is the
number of fields in the filter definition. Each rule value is separated
from the next by a "|" character. The first rule value is compared with
the value of the first field in the filter definition, the second rule
value is compared with the value of the second field (if any), and so
on. Thus, a class record satisfies a filter rule if, and only if, the
values of all its fields that appear in the filter definition are equal
to the corresponding rule values (that is, the conditions specified by
the rule values are AND-ed).</p>
<p>In a rule, one or more rule values can be omitted; if you omit a rule
value, you must omit all the rule values that appear on its right side
(if any). When a rule value is omitted, the value of the corresponding
record field is not considered while evaluating the condition. Omitting
a rule value is therefore equivalent to using a wildcard.</p>
<p>For example, let’s assume that the XYZ class supports a filter whose
definition consists of the following fields, in the order indicated:</p>
</blockquote>
<ul>
<li><p><em>MarketId</em></p></li>
<li><p><em>SectionId</em></p></li>
</ul>
<blockquote>
<p>A filter rule can thus contain up to two rule values: the first for
the <em>MarketId</em> field and the second for the <em>SectionId</em>
field. Assuming that “M<em>x</em>” and “S<em>x</em>” are possible valid
values for the <em>MarketId</em> and <em>SectionId</em> fields
respectively, a valid <em>FilterVal</em> string may be as follows:</p>
<p>M1|S1;M2;M3|S3</p>
<p>This string is made up of 3 filter rules, where:</p>
</blockquote>
<ul>
<li><p>The first filter rule contains a rule value for each filter
field; thus, a class record satisfies this rule if, and only if, the
<em>MarketId</em> field contains exactly the M1 value AND the
<em>SectionId</em> field contains exactly the S1 value.</p></li>
<li><p>The second rule does not contain the rule value for the
<em>SectionId</em> field; thus, a class record satisfies this rule if,
and only if, the <em>MarketId</em> field contains exactly the M2 value,
regardless of the value assumed by the <em>SectionId</em> field (in
other words, the second rule value is wildcarded).</p></li>
<li><p>The third filter rule is similar to the first one, but contains
different rule values.</p></li>
</ul>
<h3 id="sapfiltercreateres">SAPFilterCreateRes</h3>
<blockquote>
<p>The <strong>SAPFilterCreateRes</strong> PDU is sent by the SAP Server
to the SAP client in response to a <strong>SAPFilterCreateReq</strong>
PDU to communicate the result of the request to instanciate a
filter.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 231.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPFilterCreateReq</strong> PDU.</td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Unique ID of the filter assigned by the SAP Server to the filter
instance.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_FilterCreateOK</p>
<p>1 – SAP_FilterCreateSYNTAXERROR (errors in XDR code)</p>
<p>2 – SAP_FilterCreatetINVALIDFILTERKEY</p>
<p>3 – SAP_FilterCreateINVALIDFILTERLEN</p>
<p>4 – SAP_FilterCreateVALUEALREADYUSE</p></td>
</tr>
</tbody>
</table>
<h3 id="sapfiltersetreq">SAPFilterSetReq</h3>
<blockquote>
<p>The <strong>SAPFilterSetReq</strong> PDU is sent by the SAP client to
the SAP Server to deliver a request to change the filter rules
associated with the specified filter instance.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 232.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPFilterSetRes</strong> PDU.</td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Filter istance identifier(as returned by the
<strong>SAPFilterCreateRes</strong> PDU when the filter instance was
created).</td>
</tr>
<tr>
<td>FilterVal</td>
<td>STRING[<em><strong>8192</strong></em>]</td>
<td><p>New filter value. The set of rules that determine which of the
records in the class subscribed using this filter instance, are to be
notified to the client.</p>
<p>See the <strong>SAPFilterCreateReq</strong> PDU for details.</p>
<p><em><strong>The buffer length is increased from 1 K to 8
K.</strong></em></p></td>
</tr>
</tbody>
</table>
<h3 id="sapfiltersetres">SAPFilterSetRes</h3>
<blockquote>
<p>The <strong>SAPFilterSetRes</strong> PDU is sent by the SAP Server to
the SAP client in response to a <strong>SAPFilterSetReq</strong> PDU to
indicate the outcome of the request to change the filter rules
associated with the specified filter instance.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 233.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPFilterSetReq</strong> PDU.</td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Filter istance identifier. Same what as that specified in the
corresponding <strong>SAPFilterSetReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_FilterSetOK</p>
<p>1 – SAP_FilterSetSYNTAXERROR (errors in XDR code)</p>
<p>2 – SAP_FilterSetINVALIDFILTERKEY</p>
<p>3 – SAP_FilterSetINVALIDFILTERLEN</p>
<p>4 – SAP_FilterSetVALUEALREADYUSE</p></td>
</tr>
</tbody>
</table>
<h3 id="sapfilterdestroyreq">SAPFilterDestroyReq</h3>
<blockquote>
<p>The <strong>SAPFilterDestroyReq</strong> PDU is sent by the SAP
client to the SAP server to deliver a request to destroy a filter
instance.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 234.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPFilterDestroyRes</strong> PDU.</td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Filter istance identifier (returned by the
<strong>SAPFilterCreateRes</strong> PDU when the filter instance was
created).</td>
</tr>
</tbody>
</table>
<h3 id="sapfilterdestroyres">SAPFilterDestroyRes</h3>
<blockquote>
<p>The <strong>SAPFilterDestoryRes</strong> PDU is sent by the SAP
server to the SAP client in response to a
<strong>SAPFilterDestroyReq</strong> PDU to indicate the result of a
request to destroy a filter instance.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 235.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPFilterDestroyReq</strong> PDU.</td>
</tr>
<tr>
<td>FilterKey</td>
<td>ULONG</td>
<td>Filter instance identifier. Same value as that specified in the
corresponding <strong>SAPFilterDestroyReq</strong> PDU.</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_FilterDestroyOK</p>
<p>1 – SAP_FilterDestroyINVALIDFILTERKEY</p></td>
</tr>
</tbody>
</table>
<blockquote>

</blockquote>
<h2 id="query-management-pdus"><br />
Query Management PDUs</h2>
<h3 id="sapqueryreq">SAPQueryReq</h3>
<blockquote>
<p>The <strong>SAPQueryReq</strong> PDU is sent by the SAP client to the
SAP Server to request the execution of a query.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 240.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related <strong>SAPQueryRes</strong>
PDU.</td>
</tr>
<tr>
<td>QueryID</td>
<td>ULONG</td>
<td>Unique identifier of the query.</td>
</tr>
<tr>
<td>QueryParamClassID</td>
<td>ULONG</td>
<td>Unique identifier of the parameter structure of the query.</td>
</tr>
<tr>
<td>AliveTimeReq</td>
<td>ULONG</td>
<td>Time, in seconds, of “inactivity” after which the SAP Server closes
the query.</td>
</tr>
<tr>
<td>PaginationReq</td>
<td>BOOLEAN</td>
<td><p>0 – Result pagination not required</p>
<p>1 – Result pagination required</p></td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td><p>Query parameters.</p>
<p>A data record whose format complies with the query parameter
structure specified by the <em>QueryParamClassID</em> field.</p></td>
</tr>
</tbody>
</table>
<h6 id="details-2">Details</h6>
<blockquote>
<p>For the values to be assigned to the <em>QueryID</em>,
<em>QueryParamClassID</em>, and <em>Data</em> fields, refer to the SMP
Class Reference documentation of the relevant market.</p>
<p>For example, to perform a query on the OTC_TRADE class using the
OTC_TRADE_QUERY_PARAM class you should set:</p>
</blockquote>
<ul>
<li><p>The <em>QueryID</em> field to 3 (the unique identifier of the
OTC_TRADE query)</p></li>
<li><p>The <em>QueryParamClassID</em> field to 131005 (the unique
identifier of the OTC_TRADE_QUERY_PARAM class)</p></li>
<li><p>The <em>Data</em> field with a data record whose format complies
with the record structure of the OTC_TRADE_QUERY_PARAM class and which
has been filled up with the desired query conditions.</p></li>
</ul>
<h3 id="sapqueryres">SAPQueryRes</h3>
<blockquote>
<p>The <strong>SAPQueryRes</strong> PDU is sent by the SAP server to the
SAP client in response to a <strong>SAPQueryReq</strong> PDU with the
result of the query request.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 241.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPQueryReq</strong> PDU.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP Server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_QueryOK</p>
<p>1 – SAP_BadParameters</p>
<p>2 – SAP_WrongQueryID</p>
<p>3 – SAP_GenericError</p>
<p>4 - SAP_MustPaginateQuery (This error is returned when the number of
lines in the result set is greater than 1000 and the query must be
paginated)</p></td>
</tr>
<tr>
<td>RowsNumber</td>
<td>ULONG</td>
<td>Number of lines in the result-set</td>
</tr>
<tr>
<td>AliveTimeRes</td>
<td>ULONG</td>
<td>Time, in seconds, of “inactivity” after which the SAP Server closes
the query</td>
</tr>
<tr>
<td>PaginationRes</td>
<td>BOOLEAN</td>
<td><p>0 – result not paginated</p>
<p>1 – result paginated</p></td>
</tr>
</tbody>
</table>
<h3 id="sapqueryrowsdatareq">SAPQueryRowsDataReq</h3>
<blockquote>
<p>The <strong>SAPQueryRowsDataReq</strong> PDU is sent by the SAP
client to the SAP server to request the data of the result-set of the
query.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 242.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPQueryRowsDataRes</strong> PDU.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP Server</td>
</tr>
<tr>
<td>InitRow</td>
<td>ULONG</td>
<td>Initial line of the result-set requested</td>
</tr>
<tr>
<td>RowsNumber</td>
<td>ULONG</td>
<td>Number of lines of the result-set requested</td>
</tr>
</tbody>
</table>
<h3 id="sapqueryrowsdatares">SAPQueryRowsDataRes</h3>
<blockquote>
<p>The <strong>SAPQueryRowsDataRes</strong> PDU is sent by the SAP
server to the SAP client in response to a
<strong>SAPQueryRowsDataReq</strong> PDU.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 243.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPQueryRowsDataReq</strong> PDU.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – ok</p>
<p>1 – Wrong init row</p>
<p>2 – Wrong rows number</p>
<p>3 – Wrong QueryID</p>
<p>4 – Generic error</p>
<p>5 - Too many rows (This error is returned when the number of lines is
greater than 1000)</p></td>
</tr>
</tbody>
</table>
<h3 id="sapqueryrowsdata"><br />
SAPQueryRowsData</h3>
<blockquote>
<p>The <strong>SAPQueryRowsData</strong> PDU is sent by the SAP server
to the SAP client with the query data.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 244.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP server</td>
</tr>
<tr>
<td>RowNumber</td>
<td>ULONG</td>
<td>Row number of the data in the subset</td>
</tr>
<tr>
<td>QueryDataClassID</td>
<td>ULONG</td>
<td>Identifies the data structure of the <em>Data</em> field</td>
</tr>
<tr>
<td><strong>Data</strong></td>
<td></td>
<td>Data transparent for the Application layer and belonging to the
market layer</td>
</tr>
</tbody>
</table>
<h3 id="sapqueryrowsend">SAPQueryRowsEnd</h3>
<blockquote>
<p>The <strong>SAPQueryRowsEnd</strong> PDU is sent by the SAP server to
the SAP client and indicates the end of the transmission of the query
data. This PDU is also sent when the query is closed on request by the
client.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 245.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP server</td>
</tr>
<tr>
<td>ErrorCode</td>
<td>ENUM</td>
<td><p>0 – Query terminated correctly</p>
<p>1 – Query terminated by a system error</p>
<p>2 – Query terminated by AliveTimeout</p>
<p>3 – Query terminated on request by the client</p></td>
</tr>
</tbody>
</table>
<h3 id="sapquerydestroyreq">SAPQueryDestroyReq</h3>
<blockquote>
<p>The <strong>SAPQueryDestroyReq</strong> PDU is sent by the SAP client
to the SAP server to request the closure of a query.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<tbody>
<tr>
<td>FIELD NAME</td>
<td>TYPE</td>
<td>DESCRIPTION</td>
</tr>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 246.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Request ID. Specified by the SAP client, it will be returned
unchanged by the SAP Server in the related
<strong>SAPQueryDestroyRes</strong> PDU.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP Server</td>
</tr>
</tbody>
</table>
<h3 id="sapquerydestroyres"><br />
SAPQueryDestroyRes</h3>
<blockquote>
<p>The <strong>SAPQueryDestroyRes</strong> PDU is sent by the SAP server
to the SA client in response to a <strong>SAPQueryDestroyReq</strong>
PDU to communicate the result of the request to close the query.</p>
</blockquote>
<table style="width:97%;">
<colgroup>
<col style="width: 22%" />
<col style="width: 22%" />
<col style="width: 51%" />
</colgroup>
<thead>
<tr>
<th>FIELD NAME</th>
<th>TYPE</th>
<th>DESCRIPTION</th>
</tr>
</thead>
<tbody>
<tr>
<td>MsgType</td>
<td>ULONG</td>
<td>Type of the SAP PDU. Must be 247.</td>
</tr>
<tr>
<td>ReqID</td>
<td>ULONG</td>
<td>Same value as that specified by the SAP client in the related
<strong>SAPQueryDestroyReq</strong> PDU.</td>
</tr>
<tr>
<td>QueryKey</td>
<td>ULONG</td>
<td>Unique ID of the query defined by the SAP server</td>
</tr>
<tr>
<td>Result</td>
<td>ENUM</td>
<td><p>0 – SAP_DestroyOK</p>
<p>1 – SAP_DestroyWrongQueryID</p>
<p>2 – SAP_DestroyGenericError</p></td>
</tr>
</tbody>
</table>
<h1 id="smp-layer">SMP Layer</h1>
<blockquote>
<p>The SMP layer defines the classes that model the markets and
resources that these markets make available. The definition of an SMP
class includes:</p>
</blockquote>
<ul>
<li><p>The class ID</p></li>
<li><p>The class record structure (number and type of fields)</p></li>
<li><p>The keys (used to uniquely define the records of the
class)</p></li>
<li><p>The actions that may be performed by clients on the records of
the class. For each action, the SMP message that is to be sent by a
client to request it and any response messages</p></li>
<li><p>The optional filters, which may be used to narrow the scope of
the subscriptions</p></li>
<li><p>Any relations with the other classes of the SMP layer</p></li>
<li><p>The list of queries that refer to the class</p></li>
<li><p>The TradeImpact service that supports the class, for example,
INFO_BRT or TXN_INFO_PRIV.</p></li>
<li><p>If the TradeImpact service is of the transactional type, for each
action supported by the class, it is specified whether or not the data
generated by the transaction may also be returned in the response to the
action request.</p></li>
</ul>
<h2 id="smp-class-hierarchy"><br />
SMP Class Hierarchy</h2>
<blockquote>
<p>The SMP classes are logically organized into groups on the basis of
the hierarchy shown in . For example, the classes in the MTS Service
Provider group are common to all the MTS platforms and, consequently, to
all MTS markets. The REPO MTS market is modeled by the set of classes in
the MMF2 Platform / REPO market group and the general-purpose classes in
the MTS Service Provider group.</p>
<p><img src="media/image15.png"
style="width:6.06889in;height:3.69954in" /></p>
<p><strong>Figure 17.</strong> SMP Class Hierarchy</p>
<p>This document only provides general information about the SMP classes
and their organization, but does not describe in detail the classes
belonging to each group. The classes belonging to the various groups are
described in detail in special “Class Reference” manuals; for example,
the “MTS Service Provider - Class Reference” manual provides a detailed
description of the classes in the MTS Service Provider group.</p>
</blockquote>
<h2 id="summary-of-mts-classes">Summary of MTS Classes</h2>
<blockquote>
<p>This section provides a brief description of the MTS class
groups.</p>
</blockquote>
<h6 id="mst-service-provider-classes">MST Service Provider Classes</h6>
<blockquote>
<p>The classes in the MTS Service Provider group support data and
functions in common with all MTS platforms and therefore with all MTS
markets. The MTS Service Provider group comprises the following
classes:</p>
</blockquote>
<ul>
<li><p>MTS ID information. For example, classes that define the markets
and Sections defined in them, classes that define the Trading Domains
(Financial Instruments, Members, Traders, Profiles), and Settlement
classes.</p></li>
<li><p>Definition and management of traders</p></li>
<li><p>Status of Markets, Sections, Members and traders</p></li>
<li><p>Service classes (for example, descriptive classes)</p></li>
</ul>
<h6 id="mts-platform-common-classes">MTS Platform Common Classes</h6>
<blockquote>
<p>MTS platform common classes are classes common to all markets
belonging to the MTS platforms and concern, for example:</p>
</blockquote>
<ul>
<li><p>Contracts</p></li>
<li><p>Settled contracts</p></li>
</ul>
<h6 id="mts-market-specific-classes">MTS Market Specific Classes</h6>
<blockquote>
<p>MTS market specific classes are classes that model specific
information and resources of an MTS market, for example:</p>
</blockquote>
<ul>
<li><p>Market-specific registry information</p></li>
<li><p>Status of the Market, Sections, Members and Traders</p></li>
<li><p>Market Trader profiles</p></li>
<li><p>Market-specific public information</p></li>
<li><p>Market-specific private information</p></li>
</ul>
<blockquote>
<p>Some classes, such as the Registry classes, are present both on the
MTS Service Provider level and on the market level. In these cases, the
MTS Service Provider class provides general information, while the
corresponding market class provides market-specific information.</p>
</blockquote>
<h2 id="smp-conventions">SMP Conventions</h2>
<blockquote>
<p>This section provides a definition of the conventions used for all
SMP classes.</p>
</blockquote>
<h6 id="field-naming">Field Naming</h6>
<blockquote>
<p>The field names containing numerical IDs have the suffix Id (for
example, MemberId, InstrumentClassId, MsgId, etc.).</p>
<p>The field names containing alphanumeric IDs have the suffix Code (for
example, MarketCode, InstrumentClassCode, etc.).</p>
</blockquote>
<h1 id="putting-everything-together">Putting Everything Together</h1>
<blockquote>
<p>This chapter provides an example of use of the protocols in the SDP
suite. It describes the operations that a client must implement to allow
a trader to gain access to TradeImpact financial markets and
services.</p>
<p>The chapter also discusses some important technical and application
issues. It is assumed that the TCP/IP transmission network is
adopted.</p>
</blockquote>
<h2
id="retrieving-tcpip-addresses-and-opening-transport-connections"><br />
Retrieving TCP/IP Addresses and Opening Transport Connections</h2>
<blockquote>
<p>Each trader must establish a dedicated SSP session for each service
he wishes to access. Each SSP session is based on a dedicated transport
connection: it is up to the client to retrieve the addresses to be used
to open the trader's TCP/IP connections.</p>
<p>To balance the overall system load and ensure the same performance
for all users, the TradeImpact Server assigns the IP addresses and TCP
ports for access to its services dynamically (this means that the IP
addresses assigned to a given trader may vary during the course of the
same trading day). Therefore, whenever a client has to open the
transport connections needed by a trader, he must request such addresses
to the TradeImpact IP_Service.</p>
<p>To retrieve the IP addresses and the port numbers to be used to open
the transport connections for a given trader, the client must:</p>
</blockquote>
<ol type="1">
<li><p>Open a TCP/IP connection with the IP_Service service using the
appropriate address and establish an SSP session on it.</p></li>
</ol>
<ol start="4" type="1">
<li><p>Log on to the IP Service Provider, specifying the fully qualified
name and the password of the trader to be connected, and setting the
<em>Service</em> field to 0.</p></li>
<li><p>Ask for &lt;IP address, TCP port&gt; associated to the services,
by sending one of the following PDUs, depending on the IP_Request
service implementation (see chapter “<a
href="#ip-provider-service-ip_request">IP Provider Service
(IP_REQUEST)</a>”):</p></li>
</ol>
<ul>
<li><p>The <strong>SAPAddressServiceReq</strong> PDU, in case of “IP SP
– single platform”. The <strong>SAPAddressServiceRes</strong> PDU
returns the IP addresses and the port numbers that the trader has to use
to gain access to the TradeImpact services, for the platform to which
the request is addressed.</p></li>
<li><p>The<strong>SAPAddressServiceReqExt</strong> PDU, in case of “IP
SP – centralized”. The <strong>SAPAddressServiceResExt</strong> PDU
returns the IP addresses and the port numbers that the trader has to use
to gain access to the TradeImpact services, for all the platforms to
which he is enabled.</p></li>
</ul>
<ol start="6" type="1">
<li><p>Close the SSP session with the IP_Service service and the
corresponding underlying transport connection.</p></li>
<li><p>Use the retrieved adresses to open the TCP/IP connections with
the TradeImpact services reserved for the trader.</p></li>
</ol>
<h2 id="establishing-ssp-sessions"><br />
Establishing SSP Sessions</h2>
<p>The trader (or better, the client on his behalf) may now establish an
SSP session on each of the transport connections opened previously.</p>
<p>If the SSP feature is on, the client must execute the SSL handshaking
procedure before actually opening the SSP session. Then the SSP
connection can be opened, by sending and receiving the SSP PDUs.</p>
<p>The following figure shows the exchange of PDUs required to establish
an SSP session and to negotiate its characteristics (the same PDU
exchange must take place on each of the Transport Connections dedicated
to the trader).</p>
<p><img src="media/image16.wmf"
style="width:6.20833in;height:2.125in" /></p>
<h2 id="managing-the-traders-logon"><br />
Managing the Trader's Logon</h2>
<p>For each SSP session opened, before performing any other operation on
the classes supported by the connected TradeImpact service, the trader
must log on, specifying the appropriate identification and authorization
information.</p>
<p>Consequently, a <strong>SAPLogonReq</strong> PDU carrying the trader
information must be sent by the client on each SSP Session with the
fully qualified name and password of the trader. The <em>Service</em>
field must specify the TradeImpact service with which the SSP session
was opened.</p>
<p>If the trader works on platforms/markets where “single sign-on” is
implemented, the trader’s credentials entailed in the Logon PDU are
validated by a centralized system, and the authentication is valid for
all TradeImpact platforms and related markets and services (to which the
trader is enabled).</p>
<p>Otherwise the trader’s authentication is performed by the specific
platform to which Logon is directed, and is valid for that platform and
its related markets and services.</p>
<p>Please see chapter “<a
href="#managing-the-logonlogoff-sequence">Managing the Logon/Logoff
Sequence</a>” for more details about logon validation.</p>
<p>The following figure illustrates the generic PDU exchanges, which
constitute the SAP logon phase on a SSP session (the same occurs on all
SSP sessions dedicated to the trader).</p>
<p><img src="media/image17.wmf"
style="width:6.20833in;height:2.125in" /></p>
<h2 id="operating-on-classes-1"><br />
Operating on Classes</h2>
<p>As soon as he has logged on a service successfully, the trader (and
consequently, the client on his behalf) can start performing the desired
operations on the classes supported by such service.</p>
<p>The operations that a trader may perform on a class depend both on
the characteristics of the class and the TradeImpact service that
supports it. For example, classes supported by the INFO_BRT service can
only be subscribed, while classes supported by the TXN_INFO_PRIV service
may be both subscribed and operated by means of queries and action
requests (for example, to perform market functions compatible with the
trader's profile, like setting the member to Trade On/Trade Off,
inserting or modifying a proposal, nserting an order).</p>
<p>If, for any reason, the SSP session a trader has with the
TXN_INFO_PRIV service is closed (following a specific request or because
the transport connection is terminated), the trader is automatically and
immediately traded off on all markets on which he is configured.</p>
<h3 id="starting-and-managing-subscriptions">Starting and Managing
Subscriptions</h3>
<p>A subscription can be made to any class irrespective of the service
that supports it. When it is started, a subscription can be specialized
by specifying a filter to allow the trader to receive the information
present in the class of interest to him.</p>
<p>The following figure illustrates the exchange of PDUs that can take
place during the life of a subscription.</p>
<p><img src="media/image18.wmf"
style="width:6.20833in;height:4.05208in" /></p>
<h6 id="aligning-a-class">Aligning a Class</h6>
<p>The alignment of a class enables a client to get all the records in
that class. A subset of the record can be requested by specifying a
start timestamp and an end timestamp.</p>
<p>To align the data in a class correctly, the client must proceed as
follows:</p>
<ul>
<li><p>Start the subscription to the class concerned to receive the
current data (ONTIME type).</p></li>
<li><p>Receive the first record of the class or the Idle
notification.</p></li>
<li><p>Start a subscription that requests the previous data (STOP
type).</p></li>
<li><p>Receive the records coming from both the STOP subscription and
the ONTIME subscriptions. If two data items with the same application
key are received from the two flows, the one received on the ONTIME
subscription is to be taken as the valid one.</p></li>
<li><p>Once all the Records for the STOP subscription have been
received, alignment of the class has been completed
successfully.</p></li>
</ul>
<h3
id="executing-actions-on-a-class-transactional-services-only">Executing
Actions on a Class (Transactional Services Only)</h3>
<p>To request the execution of an action on a class, a trader must send
the appropriate SMP message to the market server, that is, to the
TradeImpact transactional service that implements the class (for
example, the TXN_INFO_PRIV service). As a consequence, the SAP client
must prepare the appropriate <strong>SAPExtActionReq</strong> PDU and
send it to the SAP Server.</p>
<p>If the action request carried by the <strong>SAPExtActionReq</strong>
PDU cannot be accepted by the transactional service (for example,
because the trader has not the rights to operate on the target class or
to request the action), a <strong>SAPExtActionRes</strong> PDU carrying
a negative response is returned immediately to the client.</p>
<p>If the action request can be accepted, the transactional service
starts the appropriate transaction. The transaction proceeds
independently of all the client’s other activities and ends once the
requested action has been completed. Once the transaction has been
fulfilled, the transactional service always sends a
<strong>SAPExtActionRes</strong> PDU to the client with a result
indication.</p>
<p>How the client obtains (or can obtain) the class record generated by
the transaction, depends on whether:</p>
<ul>
<li><p>The transaction inserts the record in the class or not.</p></li>
<li><p>The class allows the record to be returned to the client in the
<strong>SAPExtActionRes</strong> PDU or not.</p></li>
</ul>
<p>The most common case (shown in the figure below) is when the
transaction inserts the record in the class but the class does not allow
the record to be returned in the <strong>SAPExtActionRes</strong> PDU
(or, although the class supports this feature, the client chose to
receive the record using a subscription by setting the
<em>DataInResponse</em> field in the <strong>SAPExtActionReq</strong>
PDU as appropriate). In this case, the client must subscribe to the
class to obtain the record. A class working in this way is, for
instance, the CMF_QUOTE class.</p>
<p><img src="media/image19.png"
style="width:6.45455in;height:2.71143in" /></p>
<p>The following figure shows, instead, the case in which the
transaction still inserts the generated record in the class, but the
class requires the record to be returned in the
<strong>SAPExtActionRes</strong> PDU (or, although the class supports
both features, the client chose to receive the record in the
<strong>SAPExtActionRes</strong> PDU instead of subscribing to the
class, by setting the <em>DataInResponse</em> field in the
<strong>SAPExtActionReq</strong> PDU as appropriate). In this case, the
client obtains the record directly in the
<strong>SAPExtActionRes</strong> PDU.</p>
<p><img src="media/image20.png"
style="width:6.51948in;height:2.03534in" /></p>
<p>The last case is when the transaction does not insert the record in
the class. Therefore, the record is always returned to the client in the
<strong>SAPExtActionRes</strong> PDU (regardless of the value of the
<em>DatInResponse</em> field of the <strong>SAPExtActionReq</strong>
PDU). A class working in this way is, for instance, the
REPO_PRICE_PREVIEW class.</p>
<p><img src="media/image21.png"
style="width:6.51948in;height:2.03534in" /></p>
<h1 id="technical-notes">Technical Notes</h1>
<p>This chapter provides details on the following technical aspects:</p>
<ul>
<li><p>SSL implementation</p></li>
<li><p>Compression algorithm</p></li>
<li><p>XDR Coding</p></li>
<li><p>Request-response timeout.</p></li>
</ul>
<h2 id="ssl-implementation"><br />
SSL Implementation</h2>
<p>The SSL protocol implementation integrated in TradeImpact is the
public domain version <strong>OpenSSL</strong>.</p>
<p>The source code and documentation can be found on the web site <a
href="http://www.openssl.org">www.openssl.org</a>.</p>
<h2 id="data-compression-algorithm">Data Compression Algorithm</h2>
<p>Data compression is based on the algorithm implemented in the
<strong>zlib</strong> library.</p>
<p>The source code and documentation can be found on the web site <a
href="http://www.gzip.org/zlib">www.gzip.org/zlib</a>.</p>
<p>We recommend data be sent in compressed form only when the compressed
data is actually smaller than the non-compressed data.</p>
<h2 id="xdr-coding">XDR Coding</h2>
<p>All the data exchanged between the SSP client and the SSP Server on
the underlying Transport connection must be encoded in accordance with
the <strong>XDR</strong> standard, so as to make them independent of the
hardware and software characteristics of the hardware and software
platforms used.</p>
<h2 id="request-response-timeout">Request-Response Timeout</h2>
<p>The request-response timeout mechanism applies to the exchanges of
SSP PDUs and SAP PDUs.</p>
<p>The sender (the client or the Server) of a request PDU, which entails
receiving a response PDU, when the request is sent, must activate the
request-response timeout, which defines the maximum time by which the
reply must be received. If no response reply is received before the
timeout expires, the sender must take the relevant recovery actions.</p>
<p>For example, if he receives no response to the
<strong>SSPConCloseReq</strong> PDU before the timeout expires, the SSP
Server must forcibly close the underlying Transport connection.</p>
<p>The value of the request-response timeout must be equal to, or
greater than the value specified in the
<em>ClientReceiveAliveIntervalRes</em> field of the
<strong>SSPConOpenRes</strong> PDU.</p>
<p>Disclaimer</p>
<p>This document is for information purposes only. The information and
materials contained in this document are provided “as is” and this
publication is for information purposes only and is not a recommendation
to engage in investment activities. This publication is provided “as is”
without representation of warranty of any kind. Whilst all reasonable
care has been taken to ensure the accuracy of the content, Euronext does
not guarantee its accuracy or completeness. Euronext will not be held
liable for any loss or damages of any nature ensuing from using,
trusting or acting on information provided. No information set out or
referred to in this publication shall form the basis of any contract.
The creation of rights and obligations in respect of financial products
that are traded on the exchanges operated by Euronext’s subsidiaries
shall depend solely on the applicable rules of the market operator. All
proprietary rights and interest in or connected with this publication
shall vest in Euronext. No part of it may be redistributed or reproduced
in any form without the prior written permission of Euronext.</p>
<p>Euronext refers to Euronext N.V. and its affiliates. Information
regarding trademarks and intellectual property rights of Euronext is
located at euronext.com/terms-use.</p>
<p>© 2022, Euronext N.V. - All rights reserved</p>
<p>mtsmarkets.com</p>
