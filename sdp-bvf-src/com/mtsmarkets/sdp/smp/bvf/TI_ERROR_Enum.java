package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ERROR_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ERROR_NoError(0),
	@SerializedName("1")
	TI_ERROR_InternalError(1),
	@SerializedName("2")
	TI_ERROR_MsgNotManaged(2),
	@SerializedName("3")
	TI_ERROR_InternalDatabaseError(3),
	@SerializedName("4")
	TI_ERROR_FileError(4),
	@SerializedName("5")
	TI_ERROR_InvalidEvent(5),
	@SerializedName("6")
	TI_ERROR_InvalidFieldValue(6),
	@SerializedName("7")
	TI_ERROR_InvalidRequest(7),
	@SerializedName("8")
	TI_ERROR_LogonUserNotFound(8),
	@SerializedName("9")
	TI_ERROR_InvalidLogonState(9),
	@SerializedName("10")
	TI_ERROR_PasswordExpired(10),
	@SerializedName("11")
	TI_ERROR_WrongPassword(11),
	@SerializedName("12")
	TI_ERROR_InvalidNewPassword(12),
	@SerializedName("13")
	TI_ERROR_AccountExpired(13),
	@SerializedName("14")
	TI_ERROR_MemberStatusNotFound(14),
	@SerializedName("15")
	TI_ERROR_InvalidMemberStatus(15),
	@SerializedName("16")
	TI_ERROR_NotOwnerOfTransaction(16),
	@SerializedName("17")
	TI_ERROR_MaxConnectionsExceeded(17),
	@SerializedName("18")
	TI_ERROR_ProductNotFound(18),
	@SerializedName("19")
	TI_ERROR_MemberNotFound(19),
	@SerializedName("20")
	TI_ERROR_TraderNotFound(20),
	@SerializedName("21")
	TI_ERROR_MemberProfileNotFound(21),
	@SerializedName("22")
	TI_ERROR_InvalidPhase(22),
	@SerializedName("23")
	TI_ERROR_InvalidProposal(23),
	@SerializedName("24")
	TI_ERROR_InvalidOrder(24),
	@SerializedName("25")
	TI_ERROR_InvalidRFQ(25),
	@SerializedName("26")
	TI_ERROR_InvalidQty(26),
	@SerializedName("27")
	TI_ERROR_InvalidRate(27),
	@SerializedName("28")
	TI_ERROR_InvalidDate(28),
	@SerializedName("29")
	TI_ERROR_InvalidVerb(29),
	@SerializedName("30")
	TI_ERROR_InvalidStatus(30),
	@SerializedName("31")
	TI_ERROR_InvalidSpotPrice(31),
	@SerializedName("32")
	TI_ERROR_OrderExpired(32),
	@SerializedName("33")
	TI_ERROR_ProposalNotFound(33),
	@SerializedName("34")
	TI_ERROR_OrderNotFound(34),
	@SerializedName("35")
	TI_ERROR_QtyInTrading(35),
	@SerializedName("36")
	TI_ERROR_OrdMismatchRate(36),
	@SerializedName("37")
	TI_ERROR_MinimumSizeQty(37),
	@SerializedName("38")
	TI_ERROR_MaximumProposalExceeded(38),
	@SerializedName("39")
	TI_ERROR_SuspensionFailure(39),
	@SerializedName("40")
	TI_ERROR_ProposalNotActive(40),
	@SerializedName("41")
	TI_ERROR_ProductNotActive(41),
	@SerializedName("42")
	TI_ERROR_MemberNotActive(42),
	@SerializedName("43")
	TI_ERROR_OperatorNotActive(43),
	@SerializedName("44")
	TI_ERROR_BadParameters(44),
	@SerializedName("45")
	TI_ERROR_WrongQueryId(45),
	@SerializedName("46")
	TI_ERROR_GenericError(46),
	@SerializedName("47")
	TI_ERROR_QueryClosedbyClient(47),
	@SerializedName("48")
	TI_ERROR_Queryterminatedbyasystemerror(48),
	@SerializedName("49")
	TI_ERROR_QueryterminatedbyAliveTimeout(49),
	@SerializedName("50")
	TI_ERROR_WrongQueryKey(50),
	@SerializedName("51")
	TI_ERROR_WrongRowNumber(51),
	@SerializedName("52")
	TI_ERROR_WrongMarketID(52),
	@SerializedName("53")
	TI_ERROR_NoRigths(53),
	@SerializedName("54")
	TI_ERROR_NoSectionField(54),
	@SerializedName("55")
	TI_ERROR_NoInstrumentField(55),
	@SerializedName("56")
	TI_ERROR_NoPairFound(56),
	@SerializedName("57")
	TI_ERROR_MarketSuspended(57),
	@SerializedName("58")
	TI_ERROR_MemberMktSuspended(58),
	@SerializedName("59")
	TI_ERROR_MemberMktSectSuspended(59),
	@SerializedName("60")
	TI_ERROR_InstMarketSuspended(60),
	@SerializedName("61")
	TI_ERROR_InstClMemMarketSuspended(61),
	@SerializedName("62")
	TI_ERROR_InstClMemMarketSectSuspended(62),
	@SerializedName("63")
	TI_ERROR_InvalidData(63),
	@SerializedName("64")
	TI_ERROR_NoInstForSection(64),
	@SerializedName("65")
	TI_ERROR_ActionNotAllowed(65),
	@SerializedName("66")
	TI_ERROR_NoTransPhase(66),
	@SerializedName("67")
	TI_ERROR_WrongProposalImage(67),
	@SerializedName("68")
	TI_ERROR_CutOffProposalNotAllowed(68),
	@SerializedName("69")
	TI_ERROR_RepoConfigMismatch(69),
	@SerializedName("70")
	TI_ERROR_CCPOnlyProposal(70),
	@SerializedName("71")
	TI_ERROR_CreditExceeded(71),
	@SerializedName("72")
	TI_ERROR_InvalidOrderState(72),
	@SerializedName("73")
	TI_ERROR_WrongOrderId(73),
	@SerializedName("74")
	TI_ERROR_InvalidSize(74),
	@SerializedName("75")
	TI_ERROR_WrongMember(75),
	@SerializedName("76")
	TI_ERROR_OrderWithInvalidProposal(76),
	@SerializedName("77")
	TI_ERROR_InstrumentMismatch(77),
	@SerializedName("78")
	TI_ERROR_OrderRateMismatch(78),
	@SerializedName("79")
	TI_ERROR_InsufficientOrderQuantity(79),
	@SerializedName("80")
	TI_ERROR_OrderUnderAccept(80),
	@SerializedName("81")
	TI_ERROR_OrderInvalidQuantity(81),
	@SerializedName("82")
	TI_ERROR_QuantityNotAvailable(82),
	@SerializedName("83")
	TI_ERROR_ProviderTradeOff(83),
	@SerializedName("84")
	TI_ERROR_SelfTrade(84),
	@SerializedName("85")
	TI_ERROR_WrongTrader(85),
	@SerializedName("86")
	TI_ERROR_WrongProposalId(86),
	@SerializedName("87")
	TI_ERROR_CountrySuspended(87),
	@SerializedName("88")
	TI_ERROR_InvalidSettlementGroup(88),
	@SerializedName("89")
	TI_ERROR_TooManyProposal(89),
	@SerializedName("90")
	TI_ERROR_MustBeGiveUp(90),
	@SerializedName("91")
	TI_ERROR_CutOffExpired(91),
	@SerializedName("92")
	TI_ERROR_NonCCPMember(92),
	@SerializedName("93")
	TI_ERROR_LockedProposal(93),
	@SerializedName("94")
	TI_ERROR_CCPNotAvailable(94),
	@SerializedName("95")
	TI_ERROR_RateTooBig(95),
	@SerializedName("96")
	TI_ERROR_InvalidFloatingRate(96),
	@SerializedName("97")
	TI_ERROR_PropNoCCPMember(97),
	@SerializedName("98")
	TI_ERROR_PropSizeMissing(98),
	@SerializedName("99")
	TI_ERROR_PropInvalidSize(99),
	@SerializedName("100")
	TI_ERROR_PropInvalidTotSize(100),
	@SerializedName("101")
	TI_ERROR_PropInvalidMinQty(101),
	@SerializedName("102")
	TI_ERROR_PropInvalidRate(102),
	@SerializedName("103")
	TI_ERROR_PropInvalidSizeComb(103),
	@SerializedName("104")
	TI_ERROR_PropInvalidMinDrip(104),
	@SerializedName("105")
	TI_ERROR_PropEndDateEarlier(105),
	@SerializedName("106")
	TI_ERROR_PropQtyBelowMinDrip(106),
	@SerializedName("107")
	TI_ERROR_PropWrongEditTime(107),
	@SerializedName("108")
	TI_ERROR_PropInvalidEvent(108),
	@SerializedName("109")
	TI_ERROR_PropDateSuspended(109),
	@SerializedName("110")
	TI_ERROR_RFQInvalidRate(110),
	@SerializedName("111")
	TI_ERROR_RFQPreAccepted(111),
	@SerializedName("112")
	TI_ERROR_RFQInactive(112),
	@SerializedName("113")
	TI_ERROR_RFQEndDateEarlier(113),
	@SerializedName("114")
	TI_ERROR_RFQInvalidDates(114),
	@SerializedName("115")
	TI_ERROR_WrongAggressorMember(115),
	@SerializedName("116")
	TI_ERROR_RFQInvalidQty(116),
	@SerializedName("117")
	TI_ERROR_RFQInvalidFloatRate(117),
	@SerializedName("118")
	TI_ERROR_RFQRecipientNotEnabled(118),
	@SerializedName("119")
	TI_ERROR_RFQRecipientNotLogged(119),
	@SerializedName("120")
	TI_ERROR_WrongRFQ(120),
	@SerializedName("121")
	TI_ERROR_RFQInvalidSide(121),
	@SerializedName("122")
	TI_ERROR_RFQWrongRateChange(122),
	@SerializedName("123")
	TI_ERROR_RFQWrongQtyChange(123),
	@SerializedName("124")
	TI_ERROR_WrongGCId(124),
	@SerializedName("125")
	TI_ERROR_GCLocked(125),
	@SerializedName("126")
	TI_ERROR_GCSellerAction(126),
	@SerializedName("127")
	TI_ERROR_GCAllocRules(127),
	@SerializedName("128")
	TI_ERROR_GCInvalidAllocQty(128),
	@SerializedName("129")
	TI_ERROR_GCWrongAlloc(129),
	@SerializedName("130")
	TI_ERROR_GCWrongSelection(130),
	@SerializedName("131")
	TI_ERROR_GCMemberDisabled(131),
	@SerializedName("132")
	TI_ERROR_GCWrongDate(132),
	@SerializedName("133")
	TI_ERROR_WrongPlainVanilla(133),
	@SerializedName("134")
	TI_ERROR_InvalidStartDate(134),
	@SerializedName("135")
	TI_ERROR_InvalidEndDate(135),
	@SerializedName("136")
	TI_ERROR_EarlierStartDate(136),
	@SerializedName("137")
	TI_ERROR_IncompatibleDates(137),
	@SerializedName("138")
	TI_ERROR_DateIsHoliday(138),
	@SerializedName("139")
	TI_ERROR_DateTooFar(139),
	@SerializedName("140")
	TI_ERROR_WrongCalendarId(140),
	@SerializedName("141")
	TI_ERROR_InvalidCP(141),
	@SerializedName("142")
	TI_ERROR_WrongBond(142),
	@SerializedName("143")
	TI_ERROR_SettlStartDate(143),
	@SerializedName("144")
	TI_ERROR_BondMaturityDate(144),
	@SerializedName("145")
	TI_ERROR_InvalidFillAction(145),
	@SerializedName("146")
	TI_ERROR_WrongFillId(146),
	@SerializedName("147")
	TI_ERROR_LogonInvalidUser(147),
	@SerializedName("148")
	TI_ERROR_LogonInvalidMember(148),
	@SerializedName("149")
	TI_ERROR_TooManyTraders(149),
	@SerializedName("150")
	TI_ERROR_LogonUserSuspended(150),
	@SerializedName("151")
	TI_ERROR_LogonAccountExpired(151),
	@SerializedName("152")
	TI_ERROR_LogonWrongPassword(152),
	@SerializedName("153")
	TI_ERROR_LogonPasswordExpired(153),
	@SerializedName("154")
	TI_ERROR_InvalidRecipient(154),
	@SerializedName("155")
	TI_ERROR_ChatRFQExpired(155),
	@SerializedName("156")
	TI_ERROR_WrongOwnership(156),
	@SerializedName("157")
	TI_ERROR_ManagerOnlyAction(157),
	@SerializedName("158")
	TI_ERROR_PwdWrongTrader(158),
	@SerializedName("159")
	TI_ERROR_PwdWrongMember(159),
	@SerializedName("160")
	TI_ERROR_CLAlreadyPresent(160),
	@SerializedName("161")
	TI_ERROR_ECLReactLimit(161),
	@SerializedName("162")
	TI_ERROR_InvalidRecord(162),
	@SerializedName("163")
	TI_ERROR_CLSelf(163),
	@SerializedName("164")
	TI_ERROR_AdmInvalidMarket(164),
	@SerializedName("165")
	TI_ERROR_AdmInvalidCountry(165),
	@SerializedName("166")
	TI_ERROR_AdmWrongReceiver(166),
	@SerializedName("167")
	TI_ERROR_AdmWrongTrader(167),
	@SerializedName("168")
	TI_ERROR_NoSessionOpen(168),
	@SerializedName("169")
	TI_ERROR_NoChangeStatus(169),
	@SerializedName("170")
	TI_ERROR_AlreadyTradeOn(170),
	@SerializedName("171")
	TI_ERROR_TrInvalidMemberStatus(171),
	@SerializedName("172")
	TI_ERROR_AdmMaxVarTraders(172),
	@SerializedName("173")
	TI_ERROR_AdmMaxFixedTraders(173),
	@SerializedName("174")
	TI_ERROR_AdmSameDate(174),
	@SerializedName("175")
	TI_ERROR_AdmSelfUpdate(175),
	@SerializedName("176")
	TI_ERROR_ManagerTransaction(176),
	@SerializedName("177")
	TI_ERROR_AdmInvalidMember(177),
	@SerializedName("178")
	TI_ERROR_PwdInvalidExpiry(178),
	@SerializedName("179")
	TI_ERROR_PwdTooShort(179),
	@SerializedName("180")
	TI_ERROR_PwdNotAlpha(180),
	@SerializedName("181")
	TI_ERROR_PwdEqMember(181),
	@SerializedName("182")
	TI_ERROR_PwdEqTrader(182),
	@SerializedName("183")
	TI_ERROR_PwdMemberCode(183),
	@SerializedName("184")
	TI_ERROR_PwdEqOld(184),
	@SerializedName("185")
	TI_ERROR_InvalidChars(185),
	@SerializedName("186")
	TI_ERROR_QuoteNotFound(186),
	@SerializedName("187")
	TI_ERROR_QuoteQtyUnderMinLimit(187),
	@SerializedName("188")
	TI_ERROR_QuoteMissingField(188),
	@SerializedName("189")
	TI_ERROR_QuoteInvalidYield(189),
	@SerializedName("190")
	TI_ERROR_QuoteYldBidLowerThanAsk(190),
	@SerializedName("191")
	TI_ERROR_QuoteInvalidRequest(191),
	@SerializedName("192")
	TI_ERROR_QuoteNoConvFormula(192),
	@SerializedName("193")
	TI_ERROR_QuoteInvalidPrice(193),
	@SerializedName("194")
	TI_ERROR_QuotePrcAskLowerThanBid(194),
	@SerializedName("195")
	TI_ERROR_MaxLinkedQuotesExceeded(195),
	@SerializedName("196")
	TI_ERROR_TraderMemberMismatch(196),
	@SerializedName("197")
	TI_ERROR_SponsorLimitExceeded(197),
	@SerializedName("198")
	TI_ERROR_OnlyFASCanBeDeleted(198),
	@SerializedName("199")
	TI_ERROR_GreaterVisibleQty(199),
	@SerializedName("200")
	TI_ERROR_QtyNotMultiple(200),
	@SerializedName("201")
	TI_ERROR_FASCompletelyFilled(201),
	@SerializedName("202")
	TI_ERROR_Wrong_Currency(202),
	@SerializedName("203")
	TI_ERROR_InvalidFlowType(203),
	@SerializedName("204")
	TI_ERROR_LockedLinkedQuoteGroup(204),
	@SerializedName("205")
	TI_ERROR_MemberNotLinked(205),
	@SerializedName("206")
	TI_ERROR_CreditLineNotFound(206),
	@SerializedName("207")
	TI_ERROR_RFQInvalidPrice(207),
	@SerializedName("208")
	TI_ERROR_InvalidPriceRange(208),
	@SerializedName("209")
	TI_ERROR_InvalidYieldRange(209),
	@SerializedName("210")
	TI_ERROR_InvalidPriceTick(210),
	@SerializedName("211")
	TI_ERROR_InvalidYieldTick(211),
	@SerializedName("212")
	TI_ERROR_InvalidSponsorId(212),
	@SerializedName("213")
	TI_ERROR_QuoteOverlap(213),
	@SerializedName("214")
	TI_ERROR_InstClass_Mkt_Suspended(214),
	@SerializedName("215")
	TI_ERROR_Section_Mkt_Suspended(215),
	@SerializedName("216")
	TI_ERROR_WrongQuoteIndicativeFlag(216),
	@SerializedName("217")
	TI_ERROR_QuoteAutomaticFlagNotAllowed(217),
	@SerializedName("218")
	TI_ERROR_GCWrongCollateral(218),
	@SerializedName("219")
	TI_ERROR_InvalidRFQForRecipientStatus(219),
	@SerializedName("220")
	TI_ERROR_MaximumLinkedQuoteExceeded(220),
	@SerializedName("221")
	TI_ERROR_InvalidSettlSystemTrader(221),
	@SerializedName("222")
	TI_ERROR_QuoteTraderNotLogged(222),
	@SerializedName("223")
	TI_ERROR_QuoteMinSizeUnderMinIncrLimit(223),
	@SerializedName("224")
	TI_ERROR_QuoteSizeUnderMinLimit(224),
	@SerializedName("225")
	TI_ERROR_QuoteSizeUnderMinPropLimit(225),
	@SerializedName("226")
	TI_ERROR_QuoteWrongLinkedQuoteGroup(226),
	@SerializedName("227")
	TI_ERROR_QuoteLinkedQuoteGroupInactive(227),
	@SerializedName("228")
	TI_ERROR_QuoteMaxNumLinkedQuoteExceed(228),
	@SerializedName("229")
	TI_ERROR_WrongCalendarIdWithInstr(229),
	@SerializedName("230")
	TI_ERROR_PwdTraderCode(230),
	@SerializedName("231")
	TI_ERROR_ActionAlreadyRequired(231),
	@SerializedName("232")
	TI_ERROR_ParamMismatch(232),
	@SerializedName("233")
	TI_ERROR_RFQSettingType(233),
	@SerializedName("234")
	TI_ERROR_RFQQuoteIdMissing(234),
	@SerializedName("235")
	TI_ERROR_RFQAggrIdMissing(235),
	@SerializedName("236")
	TI_ERROR_RFQInvalidEvent(236),
	@SerializedName("237")
	TI_ERROR_RFQResponseRequired(237),
	@SerializedName("238")
	TI_ERROR_RFQInvalidSize(238),
	@SerializedName("239")
	TI_ERROR_RFQUnableChgSize(239),
	@SerializedName("240")
	TI_ERROR_QuickEditInvalidEvent(240),
	@SerializedName("241")
	TI_ERROR_TooManyIndicativeQuotes(241),
	@SerializedName("242")
	TI_ERROR_CreditRiskLimit(242),
	@SerializedName("243")
	TI_ERROR_NoAutomaticQuoteIsAvailable(243),
	@SerializedName("244")
	TI_ERROR_InvalidOrderType(244),
	@SerializedName("245")
	TI_ERROR_WrongDealId(245),
	@SerializedName("246")
	TI_ERROR_DealInvalidEvent(246),
	@SerializedName("247")
	TI_ERROR_WrongQuoteId(247),
	@SerializedName("248")
	TI_ERROR_QuoteInvalidEvent(248),
	@SerializedName("249")
	TI_ERROR_InvalidQuote(249),
	@SerializedName("250")
	TI_ERROR_QuoteInvalidSizeComb(250),
	@SerializedName("251")
	TI_ERROR_QuoteMaxNumberExceed(251),
	@SerializedName("252")
	TI_ERROR_QuoteInvalidFieldValue(252),
	@SerializedName("253")
	TI_ERROR_QuoteWrongImage(253),
	@SerializedName("254")
	TI_ERROR_QuoteCompletelyFilled(254),
	@SerializedName("255")
	TI_ERROR_QuoteInvalidSize(255),
	@SerializedName("256")
	TI_ERROR_ICNotFound(256),
	@SerializedName("257")
	TI_ERROR_AccountCodeAlreadyPresent(257),
	@SerializedName("258")
	TI_ERROR_AccountNotFound(258),
	@SerializedName("259")
	TI_ERROR_TraderNotMultiTraderMaster(259),
	@SerializedName("260")
	TI_ERROR_TraderTypeMismatch(260),
	@SerializedName("261")
	TI_ERROR_TraderNotMultiTraderSlave(261),
	@SerializedName("262")
	TI_ERROR_MaxNumberOfRevokeExceeded(262),
	@SerializedName("263")
	TI_ERROR_TraderAlreadyRepresented(263),
	@SerializedName("264")
	TI_ERROR_InvalidDescription(264),
	@SerializedName("265")
	TI_ERROR_DescriptionAlreadyPresent(265),
	@SerializedName("266")
	TI_ERROR_InventoryGroupNotExistent(266),
	@SerializedName("267")
	TI_ERROR_WrongInventoryGroupMember(267),
	@SerializedName("268")
	TI_ERROR_TradingRelationNotPresent(268),
	@SerializedName("269")
	TI_ERROR_BSMembAlreadyAssociated(269),
	@SerializedName("270")
	TI_ERROR_WrongInventoryGroup(270),
	@SerializedName("271")
	TI_ERROR_WrongInstrumentGroup(271),
	@SerializedName("272")
	TI_ERROR_WrongBSMember(272),
	@SerializedName("273")
	TI_ERROR_InventoryGroupNotEmpty(273),
	@SerializedName("274")
	TI_ERROR_InvalidWithDrawType(274),
	@SerializedName("275")
	TI_ERROR_InvalidTraderWithType(275),
	@SerializedName("276")
	TI_ERROR_InvalidMarketId(276),
	@SerializedName("277")
	TI_ERROR_InvalidInstrument(277),
	@SerializedName("278")
	TI_ERROR_InvalidSection(278),
	@SerializedName("279")
	TI_ERROR_InvalidInstrumentClass(279),
	@SerializedName("280")
	TI_ERROR_CustomInstrGrpNotFound(280),
	@SerializedName("281")
	TI_ERROR_WrongAddressType(281),
	@SerializedName("282")
	TI_ERROR_InvalidSellSideMember(282),
	@SerializedName("283")
	TI_ERROR_SellSideMemberNotEnabled(283),
	@SerializedName("284")
	TI_ERROR_MemberSalesNotFound(284),
	@SerializedName("285")
	TI_ERROR_TradingRelationInvalidEvent(285),
	@SerializedName("286")
	TI_ERROR_TradingRelationNotFound(286),
	@SerializedName("287")
	TI_ERROR_TradingRelationInvalidStatus(287),
	@SerializedName("288")
	TI_ERROR_InvalidRevokeRequest(288),
	@SerializedName("289")
	TI_ERROR_NotBuySideMember(289),
	@SerializedName("290")
	TI_ERROR_TradeAlreadySplit(290),
	@SerializedName("291")
	TI_ERROR_InvalidSplittableFlag(291),
	@SerializedName("292")
	TI_ERROR_AccountExcluded(292),
	@SerializedName("293")
	TI_ERROR_InvalidQuantityForAccount(293),
	@SerializedName("294")
	TI_ERROR_InvalidNetPositionQuantity(294),
	@SerializedName("295")
	TI_ERROR_InvalidNetPositionVerb(295),
	@SerializedName("296")
	TI_ERROR_InvalidInstrumentModalityFunction(296),
	@SerializedName("297")
	TI_ERROR_InvalidInventoryQuote(297),
	@SerializedName("298")
	TI_ERROR_WrongInventoryQuoteId(298),
	@SerializedName("299")
	TI_ERROR_InventoryQuoteNotFound(299),
	@SerializedName("300")
	TI_ERROR_WrongInventoryQuoteImage(300),
	@SerializedName("301")
	TI_ERROR_InventoryQuoteInvalidEvent(301),
	@SerializedName("302")
	TI_ERROR_MaximumInventoryQuoteExceeded(302),
	@SerializedName("303")
	TI_ERROR_InventoryQuoteInvalidMinQty(303),
	@SerializedName("304")
	TI_ERROR_OnlySingleSideCanBeDeleted(304),
	@SerializedName("305")
	TI_ERROR_RfcqNotFound(305),
	@SerializedName("306")
	TI_ERROR_RfcqRequestNotFound(306),
	@SerializedName("307")
	TI_ERROR_RfcqOrderNotFound(307),
	@SerializedName("308")
	TI_ERROR_RfcqQuoteNotFound(308),
	@SerializedName("309")
	TI_ERROR_StageOrderNotFound(309),
	@SerializedName("310")
	TI_ERROR_InvalidRfcqStatus(310),
	@SerializedName("311")
	TI_ERROR_InvalidRfcqRequestStatus(311),
	@SerializedName("312")
	TI_ERROR_InvalidRfcqQuoteStatus(312),
	@SerializedName("313")
	TI_ERROR_InvalidRfcqOrderStatus(313),
	@SerializedName("314")
	TI_ERROR_InvalidRfcqType(314),
	@SerializedName("315")
	TI_ERROR_RfcqOrderPending(315),
	@SerializedName("316")
	TI_ERROR_RfcqDepthUpdateTimeExpired(316),
	@SerializedName("317")
	TI_ERROR_InvalidRfcqDepthUpdateTime(317),
	@SerializedName("318")
	TI_ERROR_InvalidQuotation(318),
	@SerializedName("319")
	TI_ERROR_InvalidSettlDate(319),
	@SerializedName("320")
	TI_ERROR_InvalidStageOrderMember(320),
	@SerializedName("321")
	TI_ERROR_InvalidStageOrderStatus(321),
	@SerializedName("322")
	TI_ERROR_InvalidStageOrderOrderSource(322),
	@SerializedName("323")
	TI_ERROR_InvalidStageOrderClientOrder(323),
	@SerializedName("324")
	TI_ERROR_InstrumentNotFound(324),
	@SerializedName("325")
	TI_ERROR_InvalidStageOrderAccount(325),
	@SerializedName("326")
	TI_ERROR_InvalidExecTraderId(326),
	@SerializedName("327")
	TI_ERROR_WrongNominalValue(327),
	@SerializedName("328")
	TI_ERROR_HolidayDate(328),
	@SerializedName("329")
	TI_ERROR_WrongSettlmentDate(329),
	@SerializedName("330")
	TI_ERROR_WrongTypeParameter(330),
	@SerializedName("331")
	TI_ERROR_MandatoryParameter(331),
	@SerializedName("332")
	TI_ERROR_WrongFunctionId(332),
	@SerializedName("333")
	TI_ERROR_InvGroupLimitExceeded(333),
	@SerializedName("334")
	TI_ERROR_InvGroupMemberLimitExceeded(334),
	@SerializedName("335")
	TI_ERROR_InstrGrpDefNotFound(335),
	@SerializedName("336")
	TI_ERROR_CustomInstrGrpDefNotFound(336),
	@SerializedName("337")
	TI_ERROR_WrongParentId(337),
	@SerializedName("338")
	TI_ERROR_WrongGroupLevel(338),
	@SerializedName("339")
	TI_ERROR_ParentGroupIdNotEmpty(339),
	@SerializedName("340")
	TI_ERROR_TooFewRfcqInstruments(340),
	@SerializedName("341")
	TI_ERROR_InvalidStageOrderOrderType(341),
	@SerializedName("342")
	TI_ERROR_SecurityIdNotFound(342),
	@SerializedName("343")
	TI_ERROR_StageOrderWrongImage(343),
	@SerializedName("344")
	TI_ERROR_InvalidStageOrderExecutionType(344),
	@SerializedName("345")
	TI_ERROR_InvalidStageOrderNumberOfLeg(345),
	@SerializedName("346")
	TI_ERROR_InvalidTPZeroSettlement(346),
	@SerializedName("347")
	TI_ERROR_InvalidMemberTPZeroSettlement(347),
	@SerializedName("348")
	TI_ERROR_InvalidCutOffTPZeroSettlement(348),
	@SerializedName("349")
	TI_ERROR_InstrumentGroupAlreadyDeleted(349),
	@SerializedName("350")
	TI_ERROR_StageOrderLockedByAnotherTrader(350),
	@SerializedName("351")
	TI_ERROR_InvalidInstrumentPerClass(351),
	@SerializedName("352")
	TI_ERROR_InvalidTradingModality(352),
	@SerializedName("353")
	TI_ERROR_Section_Mkt_Closed(353),
	@SerializedName("354")
	TI_ERROR_InstrumentGroupNotEmpty(354),
	@SerializedName("355")
	TI_ERROR_StageOrderAlreadyLocked(355),
	@SerializedName("356")
	TI_ERROR_WildCardNotAllowed(356),
	@SerializedName("357")
	TI_ERROR_MaxFilteredICReached(357),
	@SerializedName("358")
	TI_ERROR_MaxFilteredTradableReached(358),
	@SerializedName("359")
	TI_ERROR_GroupHasActiveSubgroups(359),
	@SerializedName("360")
	TI_ERROR_InvalidQtyRange(360),
	@SerializedName("361")
	TI_ERROR_InvalidQtyTick(361),
	@SerializedName("362")
	TI_ERROR_InvalidPrice(362),
	@SerializedName("363")
	TI_ERROR_InvalidYield(363),
	@SerializedName("364")
	TI_ERROR_ClientExistingInAGroup(364),
	@SerializedName("365")
	TI_ERROR_RfcqQuoteNotFoundInFrozenBook(365),
	@SerializedName("366")
	TI_ERROR_BPVNotAvailable(366),
	@SerializedName("367")
	TI_ERROR_InvalidGCBondDefinitionType(367),
	@SerializedName("368")
	TI_ERROR_ChatAlreadyPresent(368),
	@SerializedName("369")
	TI_ERROR_RecipientNotAddressable(369),
	@SerializedName("370")
	TI_ERROR_RecipientNotLogged(370),
	@SerializedName("371")
	TI_ERROR_RecipientNoRights(371),
	@SerializedName("372")
	TI_ERROR_SenderNotAllowed(372),
	@SerializedName("373")
	TI_ERROR_CCPEligibleFlagMustBeYes(373),
	@SerializedName("374")
	TI_ERROR_WrongChatIdRequest(374),
	@SerializedName("375")
	TI_ERROR_SenderNotOwner(375),
	@SerializedName("376")
	TI_ERROR_TxnExpired(376),
	@SerializedName("377")
	TI_ERROR_WrongMemberType(377),
	@SerializedName("378")
	TI_ERROR_WrongRefTxn(378),
	@SerializedName("379")
	TI_ERROR_SenderNotAllowedOnRefTxn(379),
	@SerializedName("380")
	TI_ERROR_ChatClosed(380),
	@SerializedName("381")
	TI_ERROR_TxnFinalState(381),
	@SerializedName("382")
	TI_ERROR_ClosingMessagePresent(382),
	@SerializedName("383")
	TI_ERROR_CloginMsgNotAllowedForChat(383),
	@SerializedName("384")
	TI_ERROR_TxnNotFinalState(384),
	@SerializedName("385")
	TI_ERROR_BlockedMemberMissing(385),
	@SerializedName("386")
	TI_ERROR_InvalidBilateralFlag(386),
	@SerializedName("387")
	TI_ERROR_WrongMsgId(387),
	@SerializedName("388")
	TI_ERROR_BilateralTradingNotAllowed(388),
	@SerializedName("389")
	TI_ERROR_RFQExclusion(389),
	@SerializedName("390")
	TI_ERROR_DefaultGCInvalid(390),
	@SerializedName("391")
	TI_ERROR_RepoGCQuantityLimitNotFound(391),
	@SerializedName("392")
	TI_ERROR_AccountNotActive(392),
	@SerializedName("393")
	TI_ERROR_MarketParameterNotFound(393),
	@SerializedName("394")
	TI_ERROR_OriginatorTraderNotFound(394),
	@SerializedName("395")
	TI_ERROR_CounterpartTraderNotFound(395),
	@SerializedName("396")
	TI_ERROR_WrongSubmitter(396),
	@SerializedName("397")
	TI_ERROR_MaxNumberSecurityLimitGC(397),
	@SerializedName("398")
	TI_ERROR_OutLimitsAllocationQtyGC(398),
	@SerializedName("399")
	TI_ERROR_InvalidSettlementMode(399),
	@SerializedName("400")
	TI_ERROR_InvalidTransparentFlag(400),
	@SerializedName("401")
	TI_ERROR_DailyInflationRateNotFound(401),
	@SerializedName("402")
	TI_ERROR_InvalidAllocationTotalQuantity(402),
	@SerializedName("403")
	TI_ERROR_InvalidAllocationStatus(403),
	@SerializedName("404")
	TI_ERROR_AllocationCodeAlreadyPresent(404),
	@SerializedName("405")
	TI_ERROR_AllocationNotFound(405),
	@SerializedName("406")
	TI_ERROR_InvalidRecipientForTxn(406),
	@SerializedName("407")
	TI_ERROR_InvalidRecipientTraderForTxn(407),
	@SerializedName("408")
	TI_ERROR_CCPNotAvailableForInstrument(408),
	@SerializedName("409")
	TI_ERROR_MaxSellSideNumberExceeded(409),
	@SerializedName("410")
	TI_ERROR_AllRFCQTypeExcluded(410),
	@SerializedName("411")
	TI_ERROR_QuoteYldAskLowerThanBid(411),
	@SerializedName("412")
	TI_ERROR_InvalidAllocationVerb(412),
	@SerializedName("413")
	TI_ERROR_ExceptionsLimitExceeded(413),
	@SerializedName("414")
	TI_ERROR_RFCQDoubleSideNotEnabled(414),
	@SerializedName("415")
	TI_ERROR_InvalidTradingList(415),
	@SerializedName("416")
	TI_ERROR_InvalidTradingListLeg(416),
	@SerializedName("417")
	TI_ERROR_TradingListNotFound(417),
	@SerializedName("418")
	TI_ERROR_TradingListLegNotFound(418),
	@SerializedName("419")
	TI_ERROR_TradingListWrongMember(419),
	@SerializedName("420")
	TI_ERROR_TradingListWrongTrader(420),
	@SerializedName("421")
	TI_ERROR_TradingListInvalidStatus(421),
	@SerializedName("422")
	TI_ERROR_TradingListInvalidLegStatus(422),
	@SerializedName("423")
	TI_ERROR_TradingListInvalidLegs(423),
	@SerializedName("424")
	TI_ERROR_StageOrderInTradingList(424),
	@SerializedName("425")
	TI_ERROR_StageOrderUsedInTradingList(425),
	@SerializedName("426")
	TI_ERROR_InvalidRfcqDueInTime(426),
	@SerializedName("427")
	TI_ERROR_InvalidIOI(427),
	@SerializedName("428")
	TI_ERROR_TradingListInvalidLegQty(428),
	@SerializedName("429")
	TI_ERROR_TradingListInvalidTotalQty(429),
	@SerializedName("430")
	TI_ERROR_TradingListInvalidNumOfLegs(430),
	@SerializedName("431")
	TI_ERROR_TradingListWrongInstrType(431),
	@SerializedName("432")
	TI_ERROR_DiscloseIOIMismatchingFlags(432),
	@SerializedName("433")
	TI_ERROR_StageOrderWrongLinkIdInTradingList(433),
	@SerializedName("434")
	TI_ERROR_TradingListInvalidLink(434),
	@SerializedName("435")
	TI_ERROR_InvalidAllocationId(435),
	@SerializedName("436")
	TI_ERROR_ExchangeRateNotFound(436),
	@SerializedName("437")
	TI_ERROR_FirmQuotingDisabled(437),
	@SerializedName("438")
	TI_ERROR_IndicativeQuotingDisabled(438),
	@SerializedName("439")
	TI_ERROR_StrikerQuotingDisabled(439),
	@SerializedName("440")
	TI_ERROR_InvalidStrikerQuotationFlag(440),
	@SerializedName("441")
	TI_ERROR_QuoteInvalidStrikerPrice(441),
	@SerializedName("442")
	TI_ERROR_InvalidStrikerPriceRange(442),
	@SerializedName("443")
	TI_ERROR_QuoteInvalidStrikerYield(443),
	@SerializedName("444")
	TI_ERROR_InvalidStrikerQty(444),
	@SerializedName("445")
	TI_ERROR_MidPriceFASTotalQtyUnderLimit(445),
	@SerializedName("446")
	TI_ERROR_MidPriceFASMinExQtyUnderLimit(446),
	@SerializedName("447")
	TI_ERROR_MidPriceFASTotalQtyUnderMES(447),
	@SerializedName("448")
	TI_ERROR_MidPriceFASTotalQtyNotMultiple(448),
	@SerializedName("449")
	TI_ERROR_MidPriceFASMinExQtyNotMultiple(449),
	@SerializedName("450")
	TI_ERROR_MidPriceMaximumFASOrderExceeded(450),
	@SerializedName("451")
	TI_ERROR_MidPriceFASOrderWrongImage(451),
	@SerializedName("452")
	TI_ERROR_MidPriceFASOrderOverlap(452),
	@SerializedName("453")
	TI_ERROR_MidPriceFASOrderInvalidLimitQuotation(453),
	@SerializedName("454")
	TI_ERROR_MidPriceFOKOrderSectionNotEnabled(454),
	@SerializedName("455")
	TI_ERROR_InventoryGroupMemberInvalidComb(455),
	@SerializedName("456")
	TI_ERROR_MaxNumberOfMemberInAGroup(456),
	@SerializedName("457")
	TI_ERROR_MaxNumberOfInvGroupConfig(457),
	@SerializedName("458")
	TI_ERROR_MaxNumberOfInvGroupExceptions(458),
	@SerializedName("459")
	TI_ERROR_MaxNumberOfInvDealerGroupConfig(459),
	@SerializedName("460")
	TI_ERROR_InvalidMinExecQty(460),
	@SerializedName("461")
	TI_ERROR_DenialCounterParty(461),
	@SerializedName("462")
	TI_ERROR_InventoryQuoteIsOnlyIndicative(462),
	@SerializedName("463")
	TI_ERROR_InventoryOrderProcessing(463),
	@SerializedName("464")
	TI_ERROR_MidPriceFASMinExQtyOverCapLimit(464),
	@SerializedName("465")
	TI_ERROR_InvalidAxedBondFlags(465),
	@SerializedName("466")
	TI_ERROR_BrokerCodeNotFound(466),
	@SerializedName("467")
	TI_ERROR_BrokerCodeNotCompliant(467),
	@SerializedName("468")
	TI_ERROR_AuthenticationFailed(468),
	@SerializedName("469")
	TI_ERROR_BuySideAccountExcluded(469),
	@SerializedName("470")
	TI_ERROR_BrokerCodeInvalidEdit(470),
	@SerializedName("471")
	TI_ERROR_MaxNumACMCashOfferExceeded(471),
	@SerializedName("472")
	TI_ERROR_MaxNumACMCollateralOfferExceeded(472),
	@SerializedName("473")
	TI_ERROR_ACMCashOfferNotFound(473),
	@SerializedName("474")
	TI_ERROR_ACMCollateralOfferNotFound(474),
	@SerializedName("475")
	TI_ERROR_WrongTransactionImage(475),
	@SerializedName("476")
	TI_ERROR_ACMCashOfferQtyExceeded(476),
	@SerializedName("477")
	TI_ERROR_OnlyFromBrokerPlus(477),
	@SerializedName("478")
	TI_ERROR_DisablingNotAllowed(478),
	@SerializedName("479")
	TI_ERROR_EoiMsgTypeUnkown(479),
	@SerializedName("480")
	TI_ERROR_NoRecipientAllowed(480),
	@SerializedName("481")
	TI_ERROR_NoReferencedMsg(481),
	@SerializedName("482")
	TI_ERROR_OnlyOneRecipient(482),
	@SerializedName("483")
	TI_ERROR_EoiMsgCancelled(483),
	@SerializedName("484")
	TI_ERROR_EoiMsgNotActive(484),
	@SerializedName("485")
	TI_ERROR_DataFeedNotAllowed(485),
	@SerializedName("486")
	TI_ERROR_EoiGenericNotBlind(486),
	@SerializedName("487")
	TI_ERROR_StageOrderPartiallyFilled(487),
	@SerializedName("488")
	TI_ERROR_BVBestGroupAlreadyPresent(488),
	@SerializedName("489")
	TI_ERROR_BVBestSellSideAlreadyPresent(489),
	@SerializedName("490")
	TI_ERROR_MTSCertificationNotAllowed(490),
	@SerializedName("491")
	TI_ERROR_ActivationAllowedWithCertification(491),
	@SerializedName("492")
	TI_ERROR_FirstNameEmpty(492),
	@SerializedName("493")
	TI_ERROR_LastNameEmpty(493),
	@SerializedName("494")
	TI_ERROR_EmailEmpty(494),
	@SerializedName("495")
	TI_ERROR_PhoneEmpty(495),
	@SerializedName("496")
	TI_ERROR_ResidualMaturityNotFound(496),
	@SerializedName("497")
	TI_ERROR_PriceOrYieldMandatory(497),
	@SerializedName("498")
	TI_ERROR_ACMUnivocityAccountViolated(498),
	@SerializedName("499")
	TI_ERROR_ACMCollateralOfferBalanceExceeded(499),
	@SerializedName("500")
	TI_ERROR_ACMCashOfferBalanceExceeded(500),
	@SerializedName("501")
	TI_ERROR_AccountMandatory(501),
	@SerializedName("502")
	TI_ERROR_AccountException(502),
	@SerializedName("503")
	TI_ERROR_InvalidAccountType(503),
	@SerializedName("504")
	TI_ERROR_EmptyNote(504),
	@SerializedName("505")
	TI_ERROR_TripartyNoteNotFound(505),
	@SerializedName("506")
	TI_ERROR_WrongTriparty(506),
	@SerializedName("507")
	TI_ERROR_CounterpartyNotAccountOwner(507),
	@SerializedName("508")
	TI_ERROR_ActionNotAllowedInCurrentDate(508),
	@SerializedName("509")
	TI_ERROR_InvalidTradingType(509),
	@SerializedName("510")
	TI_ERROR_InvalidAreaCode(510),
	@SerializedName("511")
	TI_ERROR_CounterpartyMandatory(511),
	@SerializedName("512")
	TI_ERROR_PeriodNotInMarketOpen(512),
	@SerializedName("513")
	TI_ERROR_NoPairFoundSectionIC(513),
	@SerializedName("514")
	TI_ERROR_InvalidFixingTime(514),
	@SerializedName("515")
	TI_ERROR_InvalidFixingDate(515),
	@SerializedName("516")
	TI_ERROR_InvalidActionFixingInterval(516),
	@SerializedName("517")
	TI_ERROR_ExpiredFixingInterval(517),
	@SerializedName("518")
	TI_ERROR_StageOrderExecNotAllowed(518),
	@SerializedName("519")
	TI_ERROR_WildCardExisting(519),
	@SerializedName("520")
	TI_ERROR_InvalidMarkUpValue(520),
	@SerializedName("521")
	TI_ERROR_InvalidFieldForTradingModality(521),
	@SerializedName("522")
	TI_ERROR_UnseasonedNotEnabled(522),
	@SerializedName("523")
	TI_ERROR_Section_Dates_Suspended(523),
	@SerializedName("524")
	TI_ERROR_Section_InstClass_Dates_Suspended(524),
	@SerializedName("525")
	TI_ERROR_InvalidRateRange(525),
	@SerializedName("526")
	TI_ERROR_InvalidRateTick(526),
	@SerializedName("527")
	TI_ERROR_QuoteInvalidRate(527),
	@SerializedName("528")
	TI_ERROR_QuoteRateAskLowerThanBid(528),
	@SerializedName("529")
	TI_ERROR_InvalidTradableObject(529),
	@SerializedName("530")
	TI_ERROR_InvalidSectionForTradableObject(530),
	@SerializedName("531")
	TI_ERROR_InvalidICForTradableObject(531),
	@SerializedName("532")
	TI_ERROR_MnemonicAlreadyExists(532),
	@SerializedName("533")
	TI_ERROR_SponsorRelationNotFound(533),
	@SerializedName("534")
	TI_ERROR_FirstDealerNotPreferred(534),
	@SerializedName("535")
	TI_ERROR_MaxDealersExcedeed(535),
	@SerializedName("536")
	TI_ERROR_RecordNotFound(536),
	@SerializedName("537")
	TI_ERROR_RecordAlreadyPresent(537),
	@SerializedName("538")
	TI_ERROR_AreaCodeRelNotFound(538),
	@SerializedName("539")
	TI_ERROR_MinSellSideNumberNotReached(539),
	@SerializedName("540")
	TI_ERROR_DealerNotAllowedOnRFCQRespond(540),
	@SerializedName("541")
	TI_ERROR_InvalidNumOfDealers(541),
	@SerializedName("542")
	TI_ERROR_ZeroNumOfDealers(542),
	@SerializedName("543")
	TI_ERROR_MinimumDealersUnreached(543),
	@SerializedName("544")
	TI_ERROR_MinMatchingQuotesNotReached(544),
	@SerializedName("545")
	TI_ERROR_NoDealerInPreferredList(545),
	@SerializedName("546")
	TI_ERROR_MaxReactivationReached(546),
	@SerializedName("547")
	TI_ERROR_InvalidProfileType(547),
	@SerializedName("548")
	TI_ERROR_InstrumentClassExists(548),
	@SerializedName("549")
	TI_ERROR_WildCardExists(549),
	@SerializedName("550")
	TI_ERROR_WrongSubmitterMember(550),
	@SerializedName("551")
	TI_ERROR_WrongDuration(551),
	@SerializedName("552")
	TI_ERROR_GroupIdNotFound(552),
	@SerializedName("553")
	TI_ERROR_MaxNumTierGroupConfigurations(553),
	@SerializedName("554")
	TI_ERROR_MaxNumTierGroupException(554),
	@SerializedName("555")
	TI_ERROR_WrongCVA(555),
	@SerializedName("556")
	TI_ERROR_MemberNotEnableToOverrideCVA(556),
	@SerializedName("557")
	TI_ERROR_WrongTPAVisibility(557),
	@SerializedName("558")
	TI_ERROR_TradingOnBehalfNotAllowed(558),
	@SerializedName("559")
	TI_ERROR_GreaterInventoryVisibleQty(559),
	@SerializedName("560")
	TI_ERROR_CertificationWithoutMnemonic(560),
	@SerializedName("561")
	TI_ERROR_TierGroupAssociatedToTPA(561),
	@SerializedName("562")
	TI_ERROR_MaxNumOfTradingIdeaExceeded(562),
	@SerializedName("563")
	TI_ERROR_VisibleQtyNotMultiple(563),
	@SerializedName("564")
	TI_ERROR_TradableObjectDuplicated(564),
	@SerializedName("565")
	TI_ERROR_MaxNumOfBrokenDatesExceeded(565),
	@SerializedName("566")
	TI_ERROR_InstClassSectionMktSuspended(566),
	@SerializedName("567")
	TI_ERROR_CAPQuantityLimit(567),
	@SerializedName("568")
	TI_ERROR_InvalidMarkUpType(568),
	@SerializedName("569")
	TI_ERROR_MissingMaxQtyZero(569),
	@SerializedName("570")
	TI_ERROR_InvalidMarkUpConfiguration(570),
	@SerializedName("571")
	TI_ERROR_InvalidMarkUpMaxQtyOrder(571),
	@SerializedName("572")
	TI_ERROR_NumThresholdDiffFromList(572),
	@SerializedName("573")
	TI_ERROR_TransactionNotAllowedOnIC(573),
	@SerializedName("574")
	TI_ERROR_InvalidDRate(574),
	@SerializedName("575")
	TI_ERROR_InvalidDRateTick(575),
	@SerializedName("576")
	TI_ERROR_InvalidDRateRange(576),
	@SerializedName("577")
	TI_ERROR_QuoteInvalidDRate(577),
	@SerializedName("578")
	TI_ERROR_QuoteDRateBidLowerThanAsk(578),
	@SerializedName("579")
	TI_ERROR_DealerNotEnabled(579),
	@SerializedName("580")
	TI_ERROR_BuySideMemberInDealerList(580),
	@SerializedName("581")
	TI_ERROR_MaximumIOIExceeded(581),
	@SerializedName("582")
	TI_ERROR_WrongIOIImage(582),
	@SerializedName("583")
	TI_ERROR_RFCQInvalidQty(583),
	@SerializedName("584")
	TI_ERROR_RFCQWrongQtyChange(584),
	@SerializedName("585")
	TI_ERROR_WildcardBroker(585),
	@SerializedName("586")
	TI_ERROR_EmptyDepth(586),
	@SerializedName("587")
	TI_ERROR_CurveNotFound(587),
	@SerializedName("588")
	TI_ERROR_IOIClientIdentifierAlreadyPresent(588),
	@SerializedName("589")
	TI_ERROR_MembersNCL(589),
	@SerializedName("590")
	TI_ERROR_ApplyHaircutFlagNo(590),
	@SerializedName("591")
	TI_ERROR_HaircutStatusDeleted(591),
	@SerializedName("592")
	TI_ERROR_MutuallyExclusiveConfiguration(592),
	@SerializedName("593")
	TI_ERROR_InvalidHaircutValue(593),
	@SerializedName("594")
	TI_ERROR_InvalidHaircutType(594),
	@SerializedName("595")
	TI_ERROR_InvalidResMatOnIC(595),
	@SerializedName("596")
	TI_ERROR_InvalidCreditProfile(596),
	@SerializedName("597")
	TI_ERROR_InvalidMemberType(597),
	@SerializedName("598")
	TI_ERROR_InvalidMemberTypeCombination(598),
	@SerializedName("599")
	TI_ERROR_InvalidSpreadValue(599),
	@SerializedName("600")
	TI_ERROR_InvalidHaircutStatus(600),
	@SerializedName("601")
	TI_ERROR_QuantityNotEditable(601),
	@SerializedName("602")
	TI_ERROR_SettlSystemNotEnabledToHaircut(602),
	@SerializedName("603")
	TI_ERROR_InstCurrencyAlreadyPresent(603),
	@SerializedName("604")
	TI_ERROR_WarningMessageOnSize(604),
	@SerializedName("605")
	TI_ERROR_BlockingMessageOnSize(605),
	@SerializedName("606")
	TI_ERROR_WarningMessageOnRate(606),
	@SerializedName("607")
	TI_ERROR_WarningMessageOnSizeAndRate(607),
	@SerializedName("608")
	TI_ERROR_InvalidAlgoInfoType(608),
	@SerializedName("609")
	TI_ERROR_AlgoInfoChange(609),
	@SerializedName("610")
	TI_ERROR_InvalidAlgoInfoShortCode(610),
	@SerializedName("611")
	TI_ERROR_InvalidLiquidityProvision(611),
	@SerializedName("612")
	TI_ERROR_InvalidShortSellingIndicator(612),
	@SerializedName("613")
	TI_ERROR_InvalidTradingCapacityId(613),
	@SerializedName("614")
	TI_ERROR_ClientRegistrationNotFound(614),
	@SerializedName("615")
	TI_ERROR_InvalidClientIdentificationType(615),
	@SerializedName("616")
	TI_ERROR_InvalidExecID(616),
	@SerializedName("617")
	TI_ERROR_InvalidInvDecID(617),
	@SerializedName("618")
	TI_ERROR_InvalidClientID(618),
	@SerializedName("619")
	TI_ERROR_InvalidCapacityClientID(619),
	@SerializedName("620")
	TI_ERROR_InvalidQtyRFQLISPostTrade(620),
	@SerializedName("621")
	TI_ERROR_InvalidQtyRFQLISPreTrade(621),
	@SerializedName("622")
	TI_ERROR_InvalidQtyRFQLISPrePostTrade(622),
	@SerializedName("623")
	TI_ERROR_VoiceListDealerAlreadyExist(623),
	@SerializedName("624")
	TI_ERROR_VoiceListDeleted(624),
	@SerializedName("625")
	TI_ERROR_ProcessedTradeNotEligible(625),
	@SerializedName("626")
	TI_ERROR_PartialExecutionNotPermitted(626),
	@SerializedName("627")
	TI_ERROR_UserAlreadyPresent(627),
	@SerializedName("628")
	TI_ERROR_NoRigthsContactMTS(628),
	@SerializedName("629")
	TI_ERROR_InvalidSettlementInfo(629),
	@SerializedName("630")
	TI_ERROR_MaxNumRulesExceeded(630),
	@SerializedName("631")
	TI_ERROR_InvalidAssetClassEligibilityCriteria(631),
	@SerializedName("632")
	TI_ERROR_InvalidAssetClassNum(632),
	@SerializedName("633")
	TI_ERROR_MaxNumEligibilityCriteriaAssetsExceeded(633),
	@SerializedName("634")
	TI_ERROR_MaxNumCurrenciesExceeded(634),
	@SerializedName("635")
	TI_ERROR_InvalidCurrencyNum(635),
	@SerializedName("636")
	TI_ERROR_MaxNumResidualMaturitiesExceeded(636),
	@SerializedName("637")
	TI_ERROR_InvalidResidualMaturityNum(637),
	@SerializedName("638")
	TI_ERROR_InvalidDealerSelectionType(638),
	@SerializedName("639")
	TI_ERROR_InvalidDealerSelectionCriteria(639),
	@SerializedName("640")
	TI_ERROR_InvalidAutoExecutionSpreadCriterion(640),
	@SerializedName("641")
	TI_ERROR_InvalidRuleName(641),
	@SerializedName("642")
	TI_ERROR_InvalidDealerList(642),
	@SerializedName("643")
	TI_ERROR_ExecRulePriorityInvalidEdit(643),
	@SerializedName("644")
	TI_ERROR_InvalidBounds(644),
	@SerializedName("645")
	TI_ERROR_InvalidGroupName(645),
	@SerializedName("646")
	TI_ERROR_AutoExecutionDisabled(646),
	@SerializedName("647")
	TI_ERROR_AutoExecutionRulesNotAvailable(647),
	@SerializedName("648")
	TI_ERROR_GroupNameEmpty(648),
	@SerializedName("649")
	TI_ERROR_GroupNameAlreadyPresent(649),
	@SerializedName("650")
	TI_ERROR_DealerGroupLinkedToAutoExecRule(650),
	@SerializedName("651")
	TI_ERROR_DealerAlreadyPresentInList(651),
	@SerializedName("652")
	TI_ERROR_RuleNameEmpty(652),
	@SerializedName("653")
	TI_ERROR_RuleNameAlreadyPresent(653),
	@SerializedName("654")
	TI_ERROR_InvalidAssetClassSubSectionComb(654),
	@SerializedName("655")
	TI_ERROR_InvalidSubSectionEligibilityCriteria(655),
	@SerializedName("656")
	TI_ERROR_ResMatLowerBoundNotFound(656),
	@SerializedName("657")
	TI_ERROR_ResMatUpperBoundNotFound(657),
	@SerializedName("658")
	TI_ERROR_InvalidSizeLimit(658),
	@SerializedName("659")
	TI_ERROR_ResidualMaturityInvalidBounds(659),
	@SerializedName("660")
	TI_ERROR_SizeInvalidBounds(660),
	@SerializedName("661")
	TI_ERROR_DV01InvalidBounds(661),
	@SerializedName("662")
	TI_ERROR_InvalidDealerGroupDealerSelTypeComb(662),
	@SerializedName("663")
	TI_ERROR_DealerGroupEmpty(663),
	@SerializedName("664")
	TI_ERROR_InvalidDealerHitRate(664),
	@SerializedName("665")
	TI_ERROR_InvalidDealerPickupRate(665),
	@SerializedName("666")
	TI_ERROR_InvalidNegotiationTimes(666),
	@SerializedName("667")
	TI_ERROR_InvalidSpreadQuoteCMFBest(667),
	@SerializedName("668")
	TI_ERROR_InvalidSpreadQuoteBVBest(668),
	@SerializedName("669")
	TI_ERROR_InvalidWideSpread(669),
	@SerializedName("670")
	TI_ERROR_InvalidSelMinDealersVsExecMinDealer(670),
	@SerializedName("671")
	TI_ERROR_InvalidMaximumDealerVsSelMinDealers(671),
	@SerializedName("672")
	TI_ERROR_InvalidMaximumDealerVsDealerRotation(672),
	@SerializedName("673")
	TI_ERROR_InvalidMaximumDealerVsExecMinDealer(673),
	@SerializedName("674")
	TI_ERROR_MaximumDealerNotAdmitted(674),
	@SerializedName("675")
	TI_ERROR_AlwaysBeatCMFBestCombNotAdmitted(675),
	@SerializedName("676")
	TI_ERROR_AlwaysBeatBVBestCombNotAdmitted(676),
	@SerializedName("677")
	TI_ERROR_NonCompetitiveQtyExceeded(677),
	@SerializedName("678")
	TI_ERROR_BondSuspendedDueToLackCouponRate(678),
	@SerializedName("679")
	TI_ERROR_MaxNumExecTradersExceeded(679),
	@SerializedName("680")
	TI_ERROR_NumExecTradersDiffFromList(680),
	@SerializedName("681")
	TI_ERROR_InvalidDealerRotationNumber(681),
	@SerializedName("682")
	TI_ERROR_InvalidStageOrderClearingAgentId(682),
	@SerializedName("683")
	TI_ERROR_EditHaircutNotAllowed(683),
	@SerializedName("684")
	TI_ERROR_InvalidOverriddenSpotPrice(684),
	@SerializedName("685")
	TI_ERROR_InvalidInstrumentType(685),
	@SerializedName("686")
	TI_ERROR_InvalidNote(686),
	@SerializedName("687")
	TI_ERROR_InvalidAccountTypeExecType(687),
	@SerializedName("688")
	TI_ERROR_InvalidOrderTypeLimitRate(688),
	@SerializedName("689")
	TI_ERROR_InvalidEndDateModifyFgExecType(689),
	@SerializedName("690")
	TI_ERROR_InvalidNoPartialFillFgExecType(690),
	@SerializedName("691")
	TI_ERROR_InvalidApplyHaircutFgExecType(691),
	@SerializedName("692")
	TI_ERROR_InvalidTradModalityExecType(692),
	@SerializedName("693")
	TI_ERROR_OtcRegUTINotAllowed(693),
	@SerializedName("694")
	TI_ERROR_OtcRegUTIChangeNotAllowed(694),
	@SerializedName("695")
	TI_ERROR_OtcRegRTNNotAllowed(695),
	@SerializedName("696")
	TI_ERROR_OtcRegRTNChangeNotAllowed(696),
	@SerializedName("697")
	TI_ERROR_ReportSubmittingEntityInvalidFormat(697),
	@SerializedName("698")
	TI_ERROR_ReportingCounterpartyInvalidFormat(698),
	@SerializedName("699")
	TI_ERROR_ReportResponsibleEntityInvalidFormat(699),
	@SerializedName("700")
	TI_ERROR_ReportSubmittingEntityMustBeUnique(700),
	@SerializedName("701")
	TI_ERROR_ReportingCounterpartyMustBeUnique(701),
	@SerializedName("702")
	TI_ERROR_ReportResponsibleEntityMustBeUnique(702),
	@SerializedName("703")
	TI_ERROR_SectorAlreadyPresent(703),
	@SerializedName("704")
	TI_ERROR_SectorNotFound(704),
	@SerializedName("705")
	TI_ERROR_AdditionalSectorClassificationNotFound(705),
	@SerializedName("706")
	TI_ERROR_CountryNotFound(706),
	@SerializedName("707")
	TI_ERROR_BranchCountryNotFound(707),
	@SerializedName("708")
	TI_ERROR_BeneficiaryInvalidFormat(708),
	@SerializedName("709")
	TI_ERROR_AgentLenderInvalidFormat(709),
	@SerializedName("710")
	TI_ERROR_MasterAgreementTypeNotFound(710),
	@SerializedName("711")
	TI_ERROR_OtherMasterAgreementTypeInvalidComb(711),
	@SerializedName("712")
	TI_ERROR_MasterAgreementVersionInvalidFormat(712),
	@SerializedName("713")
	TI_ERROR_ClearingMemberInvalidFormat(713),
	@SerializedName("714")
	TI_ERROR_CSDParticipantInvalidFormat(714),
	@SerializedName("715")
	TI_ERROR_ClearingMemberMustBeUnique(715),
	@SerializedName("716")
	TI_ERROR_CSDParticipantMustBeUnique(716),
	@SerializedName("717")
	TI_ERROR_MemberProfileMustComplyD2C(717),
	@SerializedName("718")
	TI_ERROR_OpenTradesRequiresManualSett(718),
	@SerializedName("719")
	TI_ERROR_InvalidClientShortCode(719),
	@SerializedName("720")
	TI_ERROR_InvalidDealerClientRelationshipStatus(720),
	@SerializedName("721")
	TI_ERROR_InvalidVerbForGCTradingDealerClient(721),
	@SerializedName("722")
	TI_ERROR_InvalidLinkIdExecType(722),
	@SerializedName("723")
	TI_ERROR_PortfolioCodeInvalidFormat(723),
	@SerializedName("724")
	TI_ERROR_ClientShortCodeInvalidFormat(724),
	@SerializedName("725")
	TI_ERROR_ClientLongCodeInvalidFormat(725),
	@SerializedName("726")
	TI_ERROR_DefClientTraderNameInvalidFormat(726),
	@SerializedName("727")
	TI_ERROR_ClientLEICodeInvalidFormat(727),
	@SerializedName("728")
	TI_ERROR_AccountClientShortCodeInvalidConfig(728),
	@SerializedName("729")
	TI_ERROR_CounterpartyClientShortCodeInvalidConfig(729),
	@SerializedName("730")
	TI_ERROR_PlainVanillaNotAllowedForTradingType(730),
	@SerializedName("731")
	TI_ERROR_TradeDateNotAllowedForTradingType(731),
	@SerializedName("732")
	TI_ERROR_RateFlagShouldBeEqualBetweenSOAndRFCQ(732),
	@SerializedName("733")
	TI_ERROR_DealerListTypeNegativeExeTypeOTC(733),
	@SerializedName("734")
	TI_ERROR_DealerListTypeShouldBePosOrNegNumDealer(734),
	@SerializedName("735")
	TI_ERROR_NumberOfDealersLowerDefLimit(735),
	@SerializedName("736")
	TI_ERROR_BilOnlyFlagMustAssumeYesCorrSOYes(736),
	@SerializedName("737")
	TI_ERROR_StartDateShouldBeLessEndDate(737),
	@SerializedName("738")
	TI_ERROR_CutOffExpiredForSettlMod(738),
	@SerializedName("739")
	TI_ERROR_ClearingAgentCannotDiffOrdersSameLinkId(739),
	@SerializedName("740")
	TI_ERROR_AccountIdCannotDiffOrdersSameLinkId(740),
	@SerializedName("741")
	TI_ERROR_ApplyHaircutFgShouldBeEqBetweenRFCQAndSO(741),
	@SerializedName("742")
	TI_ERROR_AlgoInfoDiffPredValues(742),
	@SerializedName("743")
	TI_ERROR_ClientIdInfoDiffPredValues(743),
	@SerializedName("744")
	TI_ERROR_BuySellIndCannotDiffSO(744),
	@SerializedName("745")
	TI_ERROR_QuantityCannotDiffSO(745),
	@SerializedName("746")
	TI_ERROR_SellSideMembersDiffPredOnes(746),
	@SerializedName("747")
	TI_ERROR_CounterpartyDiffPredOne(747),
	@SerializedName("748")
	TI_ERROR_AccountIdCannotDiffSO(748),
	@SerializedName("749")
	TI_ERROR_ClearingAgentIdDiffSO(749),
	@SerializedName("750")
	TI_ERROR_MemberProfileNotEnabledToSO(750),
	@SerializedName("751")
	TI_ERROR_InvalidDealerClientFg(751),
	@SerializedName("752")
	TI_ERROR_ClientTraderNameInvalidFormat(752),
	@SerializedName("753")
	TI_ERROR_DealerClientRelationNotFound(753),
	@SerializedName("754")
	TI_ERROR_DealerClientRelationDeleted(754),
	@SerializedName("755")
	TI_ERROR_CAPSSettlSystemNotEnabledToCAPS(755),
	@SerializedName("756")
	TI_ERROR_CAPSAlreadyPresent(756),
	@SerializedName("757")
	TI_ERROR_CAPSInvalidIndirectRelation(757),
	@SerializedName("758")
	TI_ERROR_CAPSRequiresAutomaticSett(758),
	@SerializedName("759")
	TI_ERROR_CAPSInvalidDailyCAPSLimit(759),
	@SerializedName("760")
	TI_ERROR_CAPSLimitExceeded(760),
	@SerializedName("761")
	TI_ERROR_CAPSLimitNotConfigured(761),
	@SerializedName("762")
	TI_ERROR_CAPSLocked(762),
	@SerializedName("763")
	TI_ERROR_TradingNotAdmitted(763),
	@SerializedName("764")
	TI_ERROR_OriginatorCAPSLimitExceeded(764),
	@SerializedName("765")
	TI_ERROR_OriginatorCAPSLimitNotConfigured(765),
	@SerializedName("766")
	TI_ERROR_OriginatorCAPSLocked(766),
	@SerializedName("767")
	TI_ERROR_CounterpartCAPSLimitExceeded(767),
	@SerializedName("768")
	TI_ERROR_CounterpartCAPSLimitNotConfigured(768),
	@SerializedName("769")
	TI_ERROR_CounterpartCAPSLocked(769),
	@SerializedName("770")
	TI_ERROR_DateDiscrepancyBetweenSOAndTxn(770),
	@SerializedName("771")
	TI_ERROR_SPDiscrepancyBetweenSOAndTransaction(771),
	@SerializedName("772")
	TI_ERROR_RateDiscrepancyBetweenSOAndTransaction(772),
	@SerializedName("773")
	TI_ERROR_TradingListPrivateExecTraderSetInSO(773),
	@SerializedName("774")
	TI_ERROR_SOAlreadyAssociatedToOTCTransaction(774),
	@SerializedName("775")
	TI_ERROR_FieldValueDiscBetweenSOAndRFCQOTC(775),
	@SerializedName("776")
	TI_ERROR_FieldValueDiscBetweenSOAndTradingList(776),
	@SerializedName("777")
	TI_ERROR_AlgoInfoDiscBetweenSOAndTransaction(777),
	@SerializedName("778")
	TI_ERROR_MaxNumExecutionTimesExceeded(778),
	@SerializedName("779")
	TI_ERROR_InvalidExecutionTimesNum(779),
	@SerializedName("780")
	TI_ERROR_ExecutionTimeNotAdmitted(780),
	@SerializedName("781")
	TI_ERROR_WrongSortingExecutionTimes(781),
	@SerializedName("782")
	TI_ERROR_ExecutionTimesDuplicated(782),
	@SerializedName("783")
	TI_ERROR_ExecutionTimeListNotAdmitted(783),
	@SerializedName("784")
	TI_ERROR_ActionNotAllowedExecutionTime(784),
	@SerializedName("785")
	TI_ERROR_DirectBuySideMemberAlreadySet(785),
	@SerializedName("786")
	TI_ERROR_TotalSplitFillMinSizeQty(786),
	@SerializedName("787")
	TI_ERROR_IncompatibleSettlModeConfiguration(787),
	@SerializedName("788")
	TI_ERROR_DefaultExecTraderNotPermitted(788),
	@SerializedName("789")
	TI_ERROR_AutoExecutionInProgress(789),
	@SerializedName("790")
	TI_ERROR_NoBeatLimitPriceDeviation(790),
	@SerializedName("791")
	TI_ERROR_InvalidStageOrderClientLimitQuotation(791),
	@SerializedName("792")
	TI_ERROR_LimitSpreadNotAllowedByRFCQType(792),
	@SerializedName("793")
	TI_ERROR_WrongTradeRegistrationId(793),
	@SerializedName("794")
	TI_ERROR_InvalidDealerOrderId(794),
	@SerializedName("795")
	TI_ERROR_WrongOriginalDealerOrderId(795),
	@SerializedName("796")
	TI_ERROR_MaxRateCapBreach(796),
	@SerializedName("797")
	TI_ERROR_MinRateCapBreach(797),
	@SerializedName("798")
	TI_ERROR_EndDateIdCapBreach(798),
	@SerializedName("799")
	TI_ERROR_DaysCapBreach(799),
	@SerializedName("800")
	TI_ERROR_BuySideMemberNotEnabled(800),
	@SerializedName("801")
	TI_ERROR_LimitSpreadStageOrderNotAllowedByRFCQType(801),
	@SerializedName("802")
	TI_ERROR_TooManyInstrument(802),
	@SerializedName("803")
	TI_ERROR_AggregatedStageOrderWithoutSpread(803),
	@SerializedName("804")
	TI_ERROR_MemberNotEnabled(804),
	@SerializedName("805")
	TI_ERROR_EurexAccountAlreadyPresent(805),
	@SerializedName("806")
	TI_ERROR_InvalidEurexMemberId(806),
	@SerializedName("807")
	TI_ERROR_InvalidEurexTraderId(807),
	@SerializedName("808")
	TI_ERROR_InvalidEurexAutoApprovalRuleId(808),
	@SerializedName("809")
	TI_ERROR_InvalidEurexDefaultFlag(809),
	@SerializedName("810")
	TI_ERROR_InvalidEurexAccountId(810),
	@SerializedName("811")
	TI_ERROR_InvalidHedgeRatio(811),
	@SerializedName("812")
	TI_ERROR_TradeRegistrationBasisInvalidNumOfLegs(812),
	@SerializedName("813")
	TI_ERROR_MemberNotFoundEurexAccount(813),
	@SerializedName("814")
	TI_ERROR_InvalidTradeRegistrationType(814),
	@SerializedName("815")
	TI_ERROR_MemberNotEnabledToSendRFCQPortfolio(815),
	@SerializedName("816")
	TI_ERROR_DisabledByGCM(816),
	@SerializedName("817")
	TI_ERROR_ExcededGCMSizeLimit(817),
	@SerializedName("818")
	TI_ERROR_AmountBothZero(818),
	@SerializedName("819")
	TI_ERROR_AmountBothGreaterZero(819),
	@SerializedName("820")
	TI_ERROR_10YBenchmarkBondNotFound(820),
	@SerializedName("821")
	TI_ERROR_MaximumRFCQPortfolioExceeded(821),
	@SerializedName("822")
	TI_ERROR_VisibleQtyGreaterMinQty(822),
	@SerializedName("823")
	TI_ERROR_PortfolioInvalidNumOfLegs(823),
	@SerializedName("824")
	TI_ERROR_ISINReferenceDataNotAvailable(824),
	@SerializedName("825")
	TI_ERROR_ISINNotMTSCompliantBond(825),
	@SerializedName("826")
	TI_ERROR_ISINExceededDailyMaxNumListableBonds(826),
	@SerializedName("827")
	TI_ERROR_ISINExceededListingCutoffTime(827),
	@SerializedName("828")
	TI_ERROR_InvalidCharactersForISINCode(828),
	@SerializedName("829")
	TI_ERROR_ISINBondListingProcessing(829),
	@SerializedName("830")
	TI_ERROR_InvalidPreviewId(830),
	@SerializedName("831")
	TI_ERROR_IncompatibleMOCFixingTime(831),
	@SerializedName("832")
	TI_ERROR_IncompatibleMOCCutOffTime(832),
	@SerializedName("833")
	TI_ERROR_InvalidValueForClosingTypeMOC(833),
	@SerializedName("834")
	TI_ERROR_MOCAcceptanceTimeoutExceedMOCFixingTime(834),
	@SerializedName("835")
	TI_ERROR_MOCCutOffTimeExpired(835),
	@SerializedName("836")
	TI_ERROR_MaxNumListingRequestsExceeded(836),
	@SerializedName("837")
	TI_ERROR_ISINAlreadyPresent(837),
	@SerializedName("838")
	TI_ERROR_MemberSalesExceptionInvComb(838),
	@SerializedName("839")
	TI_ERROR_InvalidProductType(839),
	@SerializedName("840")
	TI_ERROR_InvalidRatingCategory(840);

	private int value;

	TI_ERROR_Enum(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
	public String getDesc()
	{
		return getDesc(value);
	}
	public static String getDesc(int value)
	{
		if (value == TI_ERROR_NoError.ordinal())
			return "All right";
		if (value == TI_ERROR_InternalError.ordinal())
			return "Internal error";
		if (value == TI_ERROR_MsgNotManaged.ordinal())
			return "Message not managed";
		if (value == TI_ERROR_InternalDatabaseError.ordinal())
			return "Internal Database error";
		if (value == TI_ERROR_FileError.ordinal())
			return "I/O error on file";
		if (value == TI_ERROR_InvalidEvent.ordinal())
			return "Invalid event";
		if (value == TI_ERROR_InvalidFieldValue.ordinal())
			return "Invalid field value";
		if (value == TI_ERROR_InvalidRequest.ordinal())
			return "Invalid request";
		if (value == TI_ERROR_LogonUserNotFound.ordinal())
			return "User logon not found";
		if (value == TI_ERROR_InvalidLogonState.ordinal())
			return "Invalid logon state";
		if (value == TI_ERROR_PasswordExpired.ordinal())
			return "Password expired";
		if (value == TI_ERROR_WrongPassword.ordinal())
			return "Wrong Password";
		if (value == TI_ERROR_InvalidNewPassword.ordinal())
			return "Invalid new password";
		if (value == TI_ERROR_AccountExpired.ordinal())
			return "Account Expired";
		if (value == TI_ERROR_MemberStatusNotFound.ordinal())
			return "Member status not found";
		if (value == TI_ERROR_InvalidMemberStatus.ordinal())
			return "Invalid member status";
		if (value == TI_ERROR_NotOwnerOfTransaction.ordinal())
			return "Sender not owner of transaction";
		if (value == TI_ERROR_MaxConnectionsExceeded.ordinal())
			return "Max number of connection exceeded";
		if (value == TI_ERROR_ProductNotFound.ordinal())
			return "Product not found";
		if (value == TI_ERROR_MemberNotFound.ordinal())
			return "Member not found";
		if (value == TI_ERROR_TraderNotFound.ordinal())
			return "Trader not found";
		if (value == TI_ERROR_MemberProfileNotFound.ordinal())
			return "Member profile not found";
		if (value == TI_ERROR_InvalidPhase.ordinal())
			return "Action not allowed in this market phase";
		if (value == TI_ERROR_InvalidProposal.ordinal())
			return "Invalid Proposal";
		if (value == TI_ERROR_InvalidOrder.ordinal())
			return "Invalid order";
		if (value == TI_ERROR_InvalidRFQ.ordinal())
			return "Invalid RFQ";
		if (value == TI_ERROR_InvalidQty.ordinal())
			return "Invalid quantity";
		if (value == TI_ERROR_InvalidRate.ordinal())
			return "Invalid rate";
		if (value == TI_ERROR_InvalidDate.ordinal())
			return "Invalid date";
		if (value == TI_ERROR_InvalidVerb.ordinal())
			return "Invalid verb";
		if (value == TI_ERROR_InvalidStatus.ordinal())
			return "Invalid status";
		if (value == TI_ERROR_InvalidSpotPrice.ordinal())
			return "Invalid spotprice";
		if (value == TI_ERROR_OrderExpired.ordinal())
			return "Order expired";
		if (value == TI_ERROR_ProposalNotFound.ordinal())
			return "Proposal not found";
		if (value == TI_ERROR_OrderNotFound.ordinal())
			return "Order not found";
		if (value == TI_ERROR_QtyInTrading.ordinal())
			return "Quantity in trading";
		if (value == TI_ERROR_OrdMismatchRate.ordinal())
			return "Mismatch rate in order";
		if (value == TI_ERROR_MinimumSizeQty.ordinal())
			return "Order quantity less than minimum size";
		if (value == TI_ERROR_MaximumProposalExceeded.ordinal())
			return "Maximum number of proposal exceeded";
		if (value == TI_ERROR_SuspensionFailure.ordinal())
			return "Suspension failed";
		if (value == TI_ERROR_ProposalNotActive.ordinal())
			return "Proposal not active";
		if (value == TI_ERROR_ProductNotActive.ordinal())
			return "Product not active";
		if (value == TI_ERROR_MemberNotActive.ordinal())
			return "Member not active";
		if (value == TI_ERROR_OperatorNotActive.ordinal())
			return "Operator not active";
		if (value == TI_ERROR_BadParameters.ordinal())
			return "Bad Parameters";
		if (value == TI_ERROR_WrongQueryId.ordinal())
			return "Wrong Query Id";
		if (value == TI_ERROR_GenericError.ordinal())
			return "Generic Error";
		if (value == TI_ERROR_QueryClosedbyClient.ordinal())
			return "Query Closed by Client";
		if (value == TI_ERROR_Queryterminatedbyasystemerror.ordinal())
			return "Query terminated by a system error";
		if (value == TI_ERROR_QueryterminatedbyAliveTimeout.ordinal())
			return "Query terminated by Alive Timeout";
		if (value == TI_ERROR_WrongQueryKey.ordinal())
			return "Wrong Query Key";
		if (value == TI_ERROR_WrongRowNumber.ordinal())
			return "Wrong Row Number";
		if (value == TI_ERROR_WrongMarketID.ordinal())
			return "Wrong Market ID";
		if (value == TI_ERROR_NoRigths.ordinal())
			return "No right to make this transaction";
		if (value == TI_ERROR_NoSectionField.ordinal())
			return "Section Field empty";
		if (value == TI_ERROR_NoInstrumentField.ordinal())
			return "Instrument Field empty";
		if (value == TI_ERROR_NoPairFound.ordinal())
			return "No pair exists with this section and instrument";
		if (value == TI_ERROR_MarketSuspended.ordinal())
			return "Market suspended";
		if (value == TI_ERROR_MemberMktSuspended.ordinal())
			return "Member suspended on this market";
		if (value == TI_ERROR_MemberMktSectSuspended.ordinal())
			return "Member suspended on this section";
		if (value == TI_ERROR_InstMarketSuspended.ordinal())
			return "Instrument suspended on this market";
		if (value == TI_ERROR_InstClMemMarketSuspended.ordinal())
			return "Member suspended on this instrument class";
		if (value == TI_ERROR_InstClMemMarketSectSuspended.ordinal())
			return "Member suspended on this instrument class and section";
		if (value == TI_ERROR_InvalidData.ordinal())
			return "Invalid data";
		if (value == TI_ERROR_NoInstForSection.ordinal())
			return "No instrument for this section";
		if (value == TI_ERROR_ActionNotAllowed.ordinal())
			return "Action not allowed";
		if (value == TI_ERROR_NoTransPhase.ordinal())
			return "Transaction not allowed in this phase";
		if (value == TI_ERROR_WrongProposalImage.ordinal())
			return "Wrong Proposal Image";
		if (value == TI_ERROR_CutOffProposalNotAllowed.ordinal())
			return "Proposal not allowed for expired cut off";
		if (value == TI_ERROR_RepoConfigMismatch.ordinal())
			return "Repo Type or Settlement Group incompatible";
		if (value == TI_ERROR_CCPOnlyProposal.ordinal())
			return "Trade Error - Proposal is CCP Only";
		if (value == TI_ERROR_CreditExceeded.ordinal())
			return "Exceeded credit limit or No credit line present";
		if (value == TI_ERROR_InvalidOrderState.ordinal())
			return "Invalid event for current order status";
		if (value == TI_ERROR_WrongOrderId.ordinal())
			return "Wrong order Id";
		if (value == TI_ERROR_InvalidSize.ordinal())
			return "Invalid Size";
		if (value == TI_ERROR_WrongMember.ordinal())
			return "Wrong Member Id";
		if (value == TI_ERROR_OrderWithInvalidProposal.ordinal())
			return "Order sent to Invalid Proposal";
		if (value == TI_ERROR_InstrumentMismatch.ordinal())
			return "Instrument mismatch";
		if (value == TI_ERROR_OrderRateMismatch.ordinal())
			return "Rate Error - Order Rate differs from Proposal";
		if (value == TI_ERROR_InsufficientOrderQuantity.ordinal())
			return "Size Error - Order Size is below the Proposal Minimum Quantity";
		if (value == TI_ERROR_OrderUnderAccept.ordinal())
			return "Queued order under acceptance";
		if (value == TI_ERROR_OrderInvalidQuantity.ordinal())
			return "Invalid Order Quantity";
		if (value == TI_ERROR_QuantityNotAvailable.ordinal())
			return "Quantity not available";
		if (value == TI_ERROR_ProviderTradeOff.ordinal())
			return "Provider member is Trade Off";
		if (value == TI_ERROR_SelfTrade.ordinal())
			return "Cannot trade against self";
		if (value == TI_ERROR_WrongTrader.ordinal())
			return "Wrong Trader Id";
		if (value == TI_ERROR_WrongProposalId.ordinal())
			return "Wrong Proposal Id";
		if (value == TI_ERROR_CountrySuspended.ordinal())
			return "Country suspended by Governance";
		if (value == TI_ERROR_InvalidSettlementGroup.ordinal())
			return "Settlement Error - Member is unable to trade this Bond Type";
		if (value == TI_ERROR_TooManyProposal.ordinal())
			return "Maximum number of proposals on single instrument exceeded";
		if (value == TI_ERROR_MustBeGiveUp.ordinal())
			return "Bilateral Proposals for this Bond Type must be name Give Up";
		if (value == TI_ERROR_CutOffExpired.ordinal())
			return "Proposal Error - Cut Off has passed";
		if (value == TI_ERROR_NonCCPMember.ordinal())
			return "Proposal Error - Member is not a member of the CCP";
		if (value == TI_ERROR_LockedProposal.ordinal())
			return "Proposal Error - Proposal is locked";
		if (value == TI_ERROR_CCPNotAvailable.ordinal())
			return "Proposal Error - CCP is not available for these dates";
		if (value == TI_ERROR_RateTooBig.ordinal())
			return "Proposal Error - Rate cannot exceed 100";
		if (value == TI_ERROR_InvalidFloatingRate.ordinal())
			return "Wrong floating rate Id";
		if (value == TI_ERROR_PropNoCCPMember.ordinal())
			return "Proposal Error - Member is not a member of a CCP";
		if (value == TI_ERROR_PropSizeMissing.ordinal())
			return "Proposal Error - Please enter a Size";
		if (value == TI_ERROR_PropInvalidSize.ordinal())
			return "Proposal Error - Invalid Size";
		if (value == TI_ERROR_PropInvalidTotSize.ordinal())
			return "Proposal Error - Invalid Total Size";
		if (value == TI_ERROR_PropInvalidMinQty.ordinal())
			return "Proposal Error - Invalid Minimum Quantity";
		if (value == TI_ERROR_PropInvalidRate.ordinal())
			return "Proposal Error - Invalid Rate";
		if (value == TI_ERROR_PropInvalidSizeComb.ordinal())
			return "Proposal Error - Invalid Size Combination";
		if (value == TI_ERROR_PropInvalidMinDrip.ordinal())
			return "Proposal Error - Invalid Minimum Proposal Quantity";
		if (value == TI_ERROR_PropEndDateEarlier.ordinal())
			return "Proposal Error - End Date chosen precedes Start Date";
		if (value == TI_ERROR_PropQtyBelowMinDrip.ordinal())
			return "Proposal Error - Invalid Size below Minimum Proposal Quantity";
		if (value == TI_ERROR_PropWrongEditTime.ordinal())
			return "Wrong Edit time";
		if (value == TI_ERROR_PropInvalidEvent.ordinal())
			return "Invalid event for current proposal status";
		if (value == TI_ERROR_PropDateSuspended.ordinal())
			return "Proposal Error - Date is suspended";
		if (value == TI_ERROR_RFQInvalidRate.ordinal())
			return "RFQ Error - Invalid Rate";
		if (value == TI_ERROR_RFQPreAccepted.ordinal())
			return "RFQ cannot be pre-Accepted";
		if (value == TI_ERROR_RFQInactive.ordinal())
			return "RFQ not Active";
		if (value == TI_ERROR_RFQEndDateEarlier.ordinal())
			return "RFQ Error - End Date chosen precedes Start Date";
		if (value == TI_ERROR_RFQInvalidDates.ordinal())
			return "RFQ Error - Invalid Dates";
		if (value == TI_ERROR_WrongAggressorMember.ordinal())
			return "Invalid Aggressor Member Id";
		if (value == TI_ERROR_RFQInvalidQty.ordinal())
			return "RFQ Error - Invalid Size";
		if (value == TI_ERROR_RFQInvalidFloatRate.ordinal())
			return "RFQ FloatRateId is invalid";
		if (value == TI_ERROR_RFQRecipientNotEnabled.ordinal())
			return "RFQ Error -  Recipient not enabled for Bond Type";
		if (value == TI_ERROR_RFQRecipientNotLogged.ordinal())
			return "RFQ Error - Recipient is not Logged On";
		if (value == TI_ERROR_WrongRFQ.ordinal())
			return "Wrong RFQ Id";
		if (value == TI_ERROR_RFQInvalidSide.ordinal())
			return "RFQ to be managed by counterparty";
		if (value == TI_ERROR_RFQWrongRateChange.ordinal())
			return "RFQ Error - Unable to change Rate";
		if (value == TI_ERROR_RFQWrongQtyChange.ordinal())
			return "RFQ Error - Unable to change Quantity";
		if (value == TI_ERROR_WrongGCId.ordinal())
			return "Wrong General Collateral Id";
		if (value == TI_ERROR_GCLocked.ordinal())
			return "Action not allowed: GC locked or already defined";
		if (value == TI_ERROR_GCSellerAction.ordinal())
			return "Action not allowed: to be defined by the seller";
		if (value == TI_ERROR_GCAllocRules.ordinal())
			return "Allocation Error - See Allocation Rules";
		if (value == TI_ERROR_GCInvalidAllocQty.ordinal())
			return "Allocation Error - Invalid Allocation Quantity";
		if (value == TI_ERROR_GCWrongAlloc.ordinal())
			return "Allocation error - Wrong quantity allocated";
		if (value == TI_ERROR_GCWrongSelection.ordinal())
			return "Allocation Error - Invalid Collateral Selected";
		if (value == TI_ERROR_GCMemberDisabled.ordinal())
			return "Allocation Error - Member disabled to specific Instrument Class";
		if (value == TI_ERROR_GCWrongDate.ordinal())
			return "Allocation Error - Wrong date for allocation";
		if (value == TI_ERROR_WrongPlainVanilla.ordinal())
			return "Action not allowed for invalid vanilla Id";
		if (value == TI_ERROR_InvalidStartDate.ordinal())
			return "Invalid Start Date";
		if (value == TI_ERROR_InvalidEndDate.ordinal())
			return "Invalid End Date";
		if (value == TI_ERROR_EarlierStartDate.ordinal())
			return "Action not allowed: start date cannot be before trade date";
		if (value == TI_ERROR_IncompatibleDates.ordinal())
			return "Incompatible Dates: start date must fall before end date";
		if (value == TI_ERROR_DateIsHoliday.ordinal())
			return "Start or End date falls on a Holiday";
		if (value == TI_ERROR_DateTooFar.ordinal())
			return "Invalid Dates - Term exceeds maximum allowed";
		if (value == TI_ERROR_WrongCalendarId.ordinal())
			return "Action not allowed: wrong calendar Id";
		if (value == TI_ERROR_InvalidCP.ordinal())
			return "Invalid Clean Price";
		if (value == TI_ERROR_WrongBond.ordinal())
			return "Bond not found";
		if (value == TI_ERROR_SettlStartDate.ordinal())
			return "Invalid Start Date - Check Bond Settlement Date";
		if (value == TI_ERROR_BondMaturityDate.ordinal())
			return "Invalid End Date - Check Bond Maturity";
		if (value == TI_ERROR_InvalidFillAction.ordinal())
			return "Action inconsistent with current fill status";
		if (value == TI_ERROR_WrongFillId.ordinal())
			return "Action not allowed for wrong fill Id";
		if (value == TI_ERROR_LogonInvalidUser.ordinal())
			return "Logon Error - Invalid Username";
		if (value == TI_ERROR_LogonInvalidMember.ordinal())
			return "Logon Error - Invalid Member ID";
		if (value == TI_ERROR_TooManyTraders.ordinal())
			return "Logon Error - Trader Limit Exceeded";
		if (value == TI_ERROR_LogonUserSuspended.ordinal())
			return "Logon Error - User is suspended";
		if (value == TI_ERROR_LogonAccountExpired.ordinal())
			return "Logon Error - Trader Account Expired";
		if (value == TI_ERROR_LogonWrongPassword.ordinal())
			return "Logon Error - Incorrect Password";
		if (value == TI_ERROR_LogonPasswordExpired.ordinal())
			return "Logon Error - Password has expired";
		if (value == TI_ERROR_InvalidRecipient.ordinal())
			return "Recipient not allowed to receive this message";
		if (value == TI_ERROR_ChatRFQExpired.ordinal())
			return "Cannot send Chat - RFQ has expired";
		if (value == TI_ERROR_WrongOwnership.ordinal())
			return "This transaction pertains to another trader";
		if (value == TI_ERROR_ManagerOnlyAction.ordinal())
			return "Administration Error - User does not have Manager profile";
		if (value == TI_ERROR_PwdWrongTrader.ordinal())
			return "Action not allowed for wrong trader Id";
		if (value == TI_ERROR_PwdWrongMember.ordinal())
			return "Action not allowed for wrong member Id";
		if (value == TI_ERROR_CLAlreadyPresent.ordinal())
			return "Admin Error - Flag already present";
		if (value == TI_ERROR_ECLReactLimit.ordinal())
			return "Admin Error - ECL Reactivation limit reached";
		if (value == TI_ERROR_InvalidRecord.ordinal())
			return "Admin Error - Record not present";
		if (value == TI_ERROR_CLSelf.ordinal())
			return "Admin Error - Cannot flag Self";
		if (value == TI_ERROR_AdmInvalidMarket.ordinal())
			return "Member not allowed to send this transaction for wrong market Id";
		if (value == TI_ERROR_AdmInvalidCountry.ordinal())
			return "Member not allowed to send this transaction for wrong country Id";
		if (value == TI_ERROR_AdmWrongReceiver.ordinal())
			return "Member not allowed to send this tx for wrong receiver details";
		if (value == TI_ERROR_AdmWrongTrader.ordinal())
			return "Member not allowed to send this transaction for wrong trader Id";
		if (value == TI_ERROR_NoSessionOpen.ordinal())
			return "Tradeon Error - Market is Closed";
		if (value == TI_ERROR_NoChangeStatus.ordinal())
			return "Tradeon Error - Member Tradeon Prohibited";
		if (value == TI_ERROR_AlreadyTradeOn.ordinal())
			return "Tradeon Error - Trader already Tradeon";
		if (value == TI_ERROR_TrInvalidMemberStatus.ordinal())
			return "Tradeon Error - Invalid Member Status";
		if (value == TI_ERROR_AdmMaxVarTraders.ordinal())
			return "Reached max number of configurable trader with Var. Window Size";
		if (value == TI_ERROR_AdmMaxFixedTraders.ordinal())
			return "Reached max number of configurable trader with Fixed Window Size";
		if (value == TI_ERROR_AdmSameDate.ordinal())
			return "Invalid End Date - Start and End date cannot be the same";
		if (value == TI_ERROR_AdmSelfUpdate.ordinal())
			return "Admin Error - Manager cannot modify own Profile";
		if (value == TI_ERROR_ManagerTransaction.ordinal())
			return "Action not compliant with the type of operator profile";
		if (value == TI_ERROR_AdmInvalidMember.ordinal())
			return "Invalid Member Choice";
		if (value == TI_ERROR_PwdInvalidExpiry.ordinal())
			return "Invalid Password - Expiry";
		if (value == TI_ERROR_PwdTooShort.ordinal())
			return "Invalid Password - Minimum 8 Characters";
		if (value == TI_ERROR_PwdNotAlpha.ordinal())
			return "Invalid Password - Must be Alphanumeric";
		if (value == TI_ERROR_PwdEqMember.ordinal())
			return "Invalid Password - Cannot be Member ID";
		if (value == TI_ERROR_PwdEqTrader.ordinal())
			return "Invalid Password - Cannot be Trader Name";
		if (value == TI_ERROR_PwdMemberCode.ordinal())
			return "Invalid Password - Cannot include Member Code";
		if (value == TI_ERROR_PwdEqOld.ordinal())
			return "Invalid Password - Must differ from previous password";
		if (value == TI_ERROR_InvalidChars.ordinal())
			return "Invalid Password - Contains Invalid Characters";
		if (value == TI_ERROR_QuoteNotFound.ordinal())
			return "Quote Error - quote does not exist";
		if (value == TI_ERROR_QuoteQtyUnderMinLimit.ordinal())
			return "Quote Error - size is less than minimum size";
		if (value == TI_ERROR_QuoteMissingField.ordinal())
			return "Quote Error - one or more mandatory fields are missing";
		if (value == TI_ERROR_QuoteInvalidYield.ordinal())
			return "Quote Error - Invalid yield";
		if (value == TI_ERROR_QuoteYldBidLowerThanAsk.ordinal())
			return "Quote Error - Bid yield is lower than Ask yield";
		if (value == TI_ERROR_QuoteInvalidRequest.ordinal())
			return "Quote Error - the request is not valid";
		if (value == TI_ERROR_QuoteNoConvFormula.ordinal())
			return "Quote Error - no formula for price<->yield conversion";
		if (value == TI_ERROR_QuoteInvalidPrice.ordinal())
			return "Quote Error - Invalid Price";
		if (value == TI_ERROR_QuotePrcAskLowerThanBid.ordinal())
			return "Quote Error - Ask price is lower than Bid price";
		if (value == TI_ERROR_MaxLinkedQuotesExceeded.ordinal())
			return "Quote Error - max number of linked quotes exceeded";
		if (value == TI_ERROR_TraderMemberMismatch.ordinal())
			return "An invalid Trader for Member was specified";
		if (value == TI_ERROR_SponsorLimitExceeded.ordinal())
			return "Quantity is greater than Sponsor Limit Quantity";
		if (value == TI_ERROR_OnlyFASCanBeDeleted.ordinal())
			return "Quote Error - Only FAS Order can be deleted";
		if (value == TI_ERROR_GreaterVisibleQty.ordinal())
			return "Quote Error - VisibleEBM / VisibleDom Qty greater than TotQty";
		if (value == TI_ERROR_QtyNotMultiple.ordinal())
			return "Quote Error - Total Size is not a multiple of Min Increment Size";
		if (value == TI_ERROR_FASCompletelyFilled.ordinal())
			return "FAS Error - Completely Filled FAS Order cannot be edited";
		if (value == TI_ERROR_Wrong_Currency.ordinal())
			return "Invalid Currency code";
		if (value == TI_ERROR_InvalidFlowType.ordinal())
			return "InvalidFlowType";
		if (value == TI_ERROR_LockedLinkedQuoteGroup.ordinal())
			return "Locked Linked Quote Group";
		if (value == TI_ERROR_MemberNotLinked.ordinal())
			return "Linked member not found";
		if (value == TI_ERROR_CreditLineNotFound.ordinal())
			return "Credit Line not found";
		if (value == TI_ERROR_RFQInvalidPrice.ordinal())
			return "RFQ Invalid Price";
		if (value == TI_ERROR_InvalidPriceRange.ordinal())
			return "Invalid Price Range";
		if (value == TI_ERROR_InvalidYieldRange.ordinal())
			return "Invalid Yield Range";
		if (value == TI_ERROR_InvalidPriceTick.ordinal())
			return "Invalid Price Tick";
		if (value == TI_ERROR_InvalidYieldTick.ordinal())
			return "Invalid Yield Tick";
		if (value == TI_ERROR_InvalidSponsorId.ordinal())
			return "Invalid SponsorId";
		if (value == TI_ERROR_QuoteOverlap.ordinal())
			return "Quote Error - Overlapping";
		if (value == TI_ERROR_InstClass_Mkt_Suspended.ordinal())
			return "Instrument class suspended on this market";
		if (value == TI_ERROR_Section_Mkt_Suspended.ordinal())
			return "Section suspended on this market";
		if (value == TI_ERROR_WrongQuoteIndicativeFlag.ordinal())
			return "Quote Error - Unable to change Indicative Flag";
		if (value == TI_ERROR_QuoteAutomaticFlagNotAllowed.ordinal())
			return "Quote Error - Automatic Only flag not allowed";
		if (value == TI_ERROR_GCWrongCollateral.ordinal())
			return "Allocation Error - Invalid collateral for floating rate contract";
		if (value == TI_ERROR_InvalidRFQForRecipientStatus.ordinal())
			return "RFQ Error - Recipient is not Logged On";
		if (value == TI_ERROR_MaximumLinkedQuoteExceeded.ordinal())
			return "Quote Error - max number of linked quotes exceeded";
		if (value == TI_ERROR_InvalidSettlSystemTrader.ordinal())
			return "Settlement Error - Trader is not configured on Settlement System";
		if (value == TI_ERROR_QuoteTraderNotLogged.ordinal())
			return "Quote Error - Trader is not logged in";
		if (value == TI_ERROR_QuoteMinSizeUnderMinIncrLimit.ordinal())
			return "Quote Error - Minimum Size is less than Minimum Increment Size";
		if (value == TI_ERROR_QuoteSizeUnderMinLimit.ordinal())
			return "Quote Error - Size is lower than Minimum Size";
		if (value == TI_ERROR_QuoteSizeUnderMinPropLimit.ordinal())
			return "Quote Error - Size below Minimum Proposal Size";
		if (value == TI_ERROR_QuoteWrongLinkedQuoteGroup.ordinal())
			return "Invalid Quote - Wrong linked Quote Group";
		if (value == TI_ERROR_QuoteLinkedQuoteGroupInactive.ordinal())
			return "Invalid Quoe - Linked Quote Group not active";
		if (value == TI_ERROR_QuoteMaxNumLinkedQuoteExceed.ordinal())
			return "Quote Error - max number of linked quotes exceeded";
		if (value == TI_ERROR_WrongCalendarIdWithInstr.ordinal())
			return "Action not allowed: mismatch between calendar and Instrument";
		if (value == TI_ERROR_PwdTraderCode.ordinal())
			return "Invalid Password - Cannot include trader name";
		if (value == TI_ERROR_ActionAlreadyRequired.ordinal())
			return "Action already required";
		if (value == TI_ERROR_ParamMismatch.ordinal())
			return "Parameter mismatch";
		if (value == TI_ERROR_RFQSettingType.ordinal())
			return "RFQ Error - RFQ setting type cannot be changed";
		if (value == TI_ERROR_RFQQuoteIdMissing.ordinal())
			return "RFQ Error: Quote message Id missing";
		if (value == TI_ERROR_RFQAggrIdMissing.ordinal())
			return "RFQ Error: Aggressor Id missing";
		if (value == TI_ERROR_RFQInvalidEvent.ordinal())
			return "Invalid RFQ event";
		if (value == TI_ERROR_RFQResponseRequired.ordinal())
			return "RFQ Error - Response required of counterparty";
		if (value == TI_ERROR_RFQInvalidSize.ordinal())
			return "RFQ Error - Invalid Size";
		if (value == TI_ERROR_RFQUnableChgSize.ordinal())
			return "RFQ Error - Unable to change Size";
		if (value == TI_ERROR_QuickEditInvalidEvent.ordinal())
			return "Invalid Quick Edit event";
		if (value == TI_ERROR_TooManyIndicativeQuotes.ordinal())
			return "Max number of indicative quotes on single instrument exceeded";
		if (value == TI_ERROR_CreditRiskLimit.ordinal())
			return "Credit Risk - Credit Risk limit reached";
		if (value == TI_ERROR_NoAutomaticQuoteIsAvailable.ordinal())
			return "Order Error - No automatic quote is available";
		if (value == TI_ERROR_InvalidOrderType.ordinal())
			return "Invalid Order Type";
		if (value == TI_ERROR_WrongDealId.ordinal())
			return "Wrong Deal Id";
		if (value == TI_ERROR_DealInvalidEvent.ordinal())
			return "Invalid event for current deal status";
		if (value == TI_ERROR_WrongQuoteId.ordinal())
			return "Quote Error - Wrong Message Id";
		if (value == TI_ERROR_QuoteInvalidEvent.ordinal())
			return "Invalid event for current quote status";
		if (value == TI_ERROR_InvalidQuote.ordinal())
			return "Invalid Quote";
		if (value == TI_ERROR_QuoteInvalidSizeComb.ordinal())
			return "Quote Error - Invalid Size Combination";
		if (value == TI_ERROR_QuoteMaxNumberExceed.ordinal())
			return "Max number of quotes on single instrument exceeded";
		if (value == TI_ERROR_QuoteInvalidFieldValue.ordinal())
			return "Quote Error: Invalid Field Value";
		if (value == TI_ERROR_QuoteWrongImage.ordinal())
			return "Wrong Quote Image";
		if (value == TI_ERROR_QuoteCompletelyFilled.ordinal())
			return "Quote is completely Filled";
		if (value == TI_ERROR_QuoteInvalidSize.ordinal())
			return "Quote Error - Invalid Size";
		if (value == TI_ERROR_ICNotFound.ordinal())
			return "Instrument Class Not Found";
		if (value == TI_ERROR_AccountCodeAlreadyPresent.ordinal())
			return "Account Code Already Present";
		if (value == TI_ERROR_AccountNotFound.ordinal())
			return "Account Not Found";
		if (value == TI_ERROR_TraderNotMultiTraderMaster.ordinal())
			return "Wrong MultiTrader Master";
		if (value == TI_ERROR_TraderTypeMismatch.ordinal())
			return "Trader Types Must Not Differ";
		if (value == TI_ERROR_TraderNotMultiTraderSlave.ordinal())
			return "Wrong MultiTrader Slave";
		if (value == TI_ERROR_MaxNumberOfRevokeExceeded.ordinal())
			return "Max Number Of Revoke Actions Exceeded";
		if (value == TI_ERROR_TraderAlreadyRepresented.ordinal())
			return "Trader Already Represented";
		if (value == TI_ERROR_InvalidDescription.ordinal())
			return "Invalid Instrument Group Description";
		if (value == TI_ERROR_DescriptionAlreadyPresent.ordinal())
			return "Instrument Group Description Already Present";
		if (value == TI_ERROR_InventoryGroupNotExistent.ordinal())
			return "Inventory Group does not exist";
		if (value == TI_ERROR_WrongInventoryGroupMember.ordinal())
			return "Wrong Member";
		if (value == TI_ERROR_TradingRelationNotPresent.ordinal())
			return "Exception or No Trading Relation Buy Side and Sell Side Members";
		if (value == TI_ERROR_BSMembAlreadyAssociated.ordinal())
			return "Buy Side already belongs to another Group";
		if (value == TI_ERROR_WrongInventoryGroup.ordinal())
			return "Wrong Inventory Group";
		if (value == TI_ERROR_WrongInstrumentGroup.ordinal())
			return "Wrong Instrument Group";
		if (value == TI_ERROR_WrongBSMember.ordinal())
			return "Wrong Buy Side Member";
		if (value == TI_ERROR_InventoryGroupNotEmpty.ordinal())
			return "Inventory Group Is Not Empty";
		if (value == TI_ERROR_InvalidWithDrawType.ordinal())
			return "Invalid Withdraw Type";
		if (value == TI_ERROR_InvalidTraderWithType.ordinal())
			return "The Trader has no Rights to send this Transaction";
		if (value == TI_ERROR_InvalidMarketId.ordinal())
			return "Invalid Market";
		if (value == TI_ERROR_InvalidInstrument.ordinal())
			return "Invalid Instrument";
		if (value == TI_ERROR_InvalidSection.ordinal())
			return "Invalid Section";
		if (value == TI_ERROR_InvalidInstrumentClass.ordinal())
			return "Invalid Instrument Class";
		if (value == TI_ERROR_CustomInstrGrpNotFound.ordinal())
			return "Custom Instrument Group Not Found";
		if (value == TI_ERROR_WrongAddressType.ordinal())
			return "Invalid Type of Addressee";
		if (value == TI_ERROR_InvalidSellSideMember.ordinal())
			return "Invalid Sell Side Member";
		if (value == TI_ERROR_SellSideMemberNotEnabled.ordinal())
			return "Sell Side Member not Enabled on this Instrument Class";
		if (value == TI_ERROR_MemberSalesNotFound.ordinal())
			return "Sales not Found";
		if (value == TI_ERROR_TradingRelationInvalidEvent.ordinal())
			return "Invalid Event Specified for the Trading Relation";
		if (value == TI_ERROR_TradingRelationNotFound.ordinal())
			return "Trading Relation not Found";
		if (value == TI_ERROR_TradingRelationInvalidStatus.ordinal())
			return "Trading Relation Invalid Status";
		if (value == TI_ERROR_InvalidRevokeRequest.ordinal())
			return "Invalid Revoke Request";
		if (value == TI_ERROR_NotBuySideMember.ordinal())
			return "Invalid Member";
		if (value == TI_ERROR_TradeAlreadySplit.ordinal())
			return "Trade Already Split";
		if (value == TI_ERROR_InvalidSplittableFlag.ordinal())
			return "Trade Cannot be Split";
		if (value == TI_ERROR_AccountExcluded.ordinal())
			return "Account Excluded By Sell Side Member";
		if (value == TI_ERROR_InvalidQuantityForAccount.ordinal())
			return "Split Quantity not Multiple of Increment Quantity";
		if (value == TI_ERROR_InvalidNetPositionQuantity.ordinal())
			return "Invalid Resulting Quantity";
		if (value == TI_ERROR_InvalidNetPositionVerb.ordinal())
			return "Invalid Resulting Verb";
		if (value == TI_ERROR_InvalidInstrumentModalityFunction.ordinal())
			return "Invalid Instrument Modality Function";
		if (value == TI_ERROR_InvalidInventoryQuote.ordinal())
			return "Invalid Inventory Quote";
		if (value == TI_ERROR_WrongInventoryQuoteId.ordinal())
			return "Wrong Inventory Quote Id";
		if (value == TI_ERROR_InventoryQuoteNotFound.ordinal())
			return "Inventory Quote not found";
		if (value == TI_ERROR_WrongInventoryQuoteImage.ordinal())
			return "Wrong Inventory Quote Image";
		if (value == TI_ERROR_InventoryQuoteInvalidEvent.ordinal())
			return "Invalid event for current Inventory Quote status";
		if (value == TI_ERROR_MaximumInventoryQuoteExceeded.ordinal())
			return "Maximum number of Inventory Quote exceeded";
		if (value == TI_ERROR_InventoryQuoteInvalidMinQty.ordinal())
			return "Inventory Quote Error - Invalid Minimum Quantity";
		if (value == TI_ERROR_OnlySingleSideCanBeDeleted.ordinal())
			return "Inventory Quote Error - Only single side Quote can be deleted";
		if (value == TI_ERROR_RfcqNotFound.ordinal())
			return "Rfcq not found";
		if (value == TI_ERROR_RfcqRequestNotFound.ordinal())
			return "Rfcq Request not found";
		if (value == TI_ERROR_RfcqOrderNotFound.ordinal())
			return "Rfcq Order not found";
		if (value == TI_ERROR_RfcqQuoteNotFound.ordinal())
			return "Rfcq Quote not found";
		if (value == TI_ERROR_StageOrderNotFound.ordinal())
			return "Stage Order not found";
		if (value == TI_ERROR_InvalidRfcqStatus.ordinal())
			return "Invalid Rfcq status";
		if (value == TI_ERROR_InvalidRfcqRequestStatus.ordinal())
			return "Invalid Rfcq Request status";
		if (value == TI_ERROR_InvalidRfcqQuoteStatus.ordinal())
			return "Invalid Rfcq Quote status";
		if (value == TI_ERROR_InvalidRfcqOrderStatus.ordinal())
			return "Invalid Rfcq Order status";
		if (value == TI_ERROR_InvalidRfcqType.ordinal())
			return "Invalid Rfcq Type";
		if (value == TI_ERROR_RfcqOrderPending.ordinal())
			return "Rfcq Order pending";
		if (value == TI_ERROR_RfcqDepthUpdateTimeExpired.ordinal())
			return "Rfcq Depth Update Time expired";
		if (value == TI_ERROR_InvalidRfcqDepthUpdateTime.ordinal())
			return "Invalid Rfcq Depth Update Time";
		if (value == TI_ERROR_InvalidQuotation.ordinal())
			return "Invalid Quotation";
		if (value == TI_ERROR_InvalidSettlDate.ordinal())
			return "Invalid Settlement Date";
		if (value == TI_ERROR_InvalidStageOrderMember.ordinal())
			return "Invalid Stage Order Member";
		if (value == TI_ERROR_InvalidStageOrderStatus.ordinal())
			return "Invalid Stage Order Status";
		if (value == TI_ERROR_InvalidStageOrderOrderSource.ordinal())
			return "Invalid Stage Order Source";
		if (value == TI_ERROR_InvalidStageOrderClientOrder.ordinal())
			return "Invalid Stage Order Client ID";
		if (value == TI_ERROR_InstrumentNotFound.ordinal())
			return "Instrument not found";
		if (value == TI_ERROR_InvalidStageOrderAccount.ordinal())
			return "Invalid Stage Order Account";
		if (value == TI_ERROR_InvalidExecTraderId.ordinal())
			return "Invalid ExecTraderId";
		if (value == TI_ERROR_WrongNominalValue.ordinal())
			return "Wrong Nominal Value";
		if (value == TI_ERROR_HolidayDate.ordinal())
			return "Wrong date/offset preview: holiday date";
		if (value == TI_ERROR_WrongSettlmentDate.ordinal())
			return "Wrong date/offset preview for settlement date";
		if (value == TI_ERROR_WrongTypeParameter.ordinal())
			return "Parameter specified for financial calculator has wrong type";
		if (value == TI_ERROR_MandatoryParameter.ordinal())
			return "Mandatory parameter for financial calculator not present";
		if (value == TI_ERROR_WrongFunctionId.ordinal())
			return "Wrong Function specified for financial calculator";
		if (value == TI_ERROR_InvGroupLimitExceeded.ordinal())
			return "Maximum number of inventory group exceeded";
		if (value == TI_ERROR_InvGroupMemberLimitExceeded.ordinal())
			return "No further action allowed for this buy side member";
		if (value == TI_ERROR_InstrGrpDefNotFound.ordinal())
			return "Instrument Group Definition Not Present";
		if (value == TI_ERROR_CustomInstrGrpDefNotFound.ordinal())
			return "Custom Instrument Group Definition Not Present";
		if (value == TI_ERROR_WrongParentId.ordinal())
			return "Wrong Parent Group";
		if (value == TI_ERROR_WrongGroupLevel.ordinal())
			return "Wrong Group Level";
		if (value == TI_ERROR_ParentGroupIdNotEmpty.ordinal())
			return "Instrument Group Is Not Empty";
		if (value == TI_ERROR_TooFewRfcqInstruments.ordinal())
			return "Too few instruments for this rfcq type";
		if (value == TI_ERROR_InvalidStageOrderOrderType.ordinal())
			return "Invalid Stage Order Type";
		if (value == TI_ERROR_SecurityIdNotFound.ordinal())
			return "SecurityId not found";
		if (value == TI_ERROR_StageOrderWrongImage.ordinal())
			return "Stage Order Wrong Image";
		if (value == TI_ERROR_InvalidStageOrderExecutionType.ordinal())
			return "Invalid Stage Order ExecutionType";
		if (value == TI_ERROR_InvalidStageOrderNumberOfLeg.ordinal())
			return "Invalid Stage OrderNumber of Leg";
		if (value == TI_ERROR_InvalidTPZeroSettlement.ordinal())
			return "Cannot settle at T+0";
		if (value == TI_ERROR_InvalidMemberTPZeroSettlement.ordinal())
			return "Member cannot settle at T+0";
		if (value == TI_ERROR_InvalidCutOffTPZeroSettlement.ordinal())
			return "Cannot settle at T+0 - CutOff expired";
		if (value == TI_ERROR_InstrumentGroupAlreadyDeleted.ordinal())
			return "Instrument Group Already Deleted";
		if (value == TI_ERROR_StageOrderLockedByAnotherTrader.ordinal())
			return "Stage Order locked by another trader";
		if (value == TI_ERROR_InvalidInstrumentPerClass.ordinal())
			return "Wrong Instrument per Instrument Class";
		if (value == TI_ERROR_InvalidTradingModality.ordinal())
			return "Wrong Trading Modality";
		if (value == TI_ERROR_Section_Mkt_Closed.ordinal())
			return "Section closed on this market";
		if (value == TI_ERROR_InstrumentGroupNotEmpty.ordinal())
			return "Instrument Group Not Empty";
		if (value == TI_ERROR_StageOrderAlreadyLocked.ordinal())
			return "Stage Order is already locked";
		if (value == TI_ERROR_WildCardNotAllowed.ordinal())
			return "Wild Card Not Allowed";
		if (value == TI_ERROR_MaxFilteredICReached.ordinal())
			return "MaxFilteredIC Reached";
		if (value == TI_ERROR_MaxFilteredTradableReached.ordinal())
			return "MaxFilteredTradable Reached";
		if (value == TI_ERROR_GroupHasActiveSubgroups.ordinal())
			return "Instrument Group Has Active Subgroups";
		if (value == TI_ERROR_InvalidQtyRange.ordinal())
			return "Invalid Quantity Range";
		if (value == TI_ERROR_InvalidQtyTick.ordinal())
			return "Invalid Quantity Tick";
		if (value == TI_ERROR_InvalidPrice.ordinal())
			return "Invalid Price";
		if (value == TI_ERROR_InvalidYield.ordinal())
			return "Invalid Yield";
		if (value == TI_ERROR_ClientExistingInAGroup.ordinal())
			return "Client Existing In A Group";
		if (value == TI_ERROR_RfcqQuoteNotFoundInFrozenBook.ordinal())
			return "Rfcq Quote Not Found In Frozen Book";
		if (value == TI_ERROR_BPVNotAvailable.ordinal())
			return "BPV Not Available";
		if (value == TI_ERROR_InvalidGCBondDefinitionType.ordinal())
			return "Default Bond configuration disabled for this GC Basket";
		if (value == TI_ERROR_ChatAlreadyPresent.ordinal())
			return "Mismatch Error - Wrong Message ID";
		if (value == TI_ERROR_RecipientNotAddressable.ordinal())
			return "Message Error - Recipient Messaging Disabled";
		if (value == TI_ERROR_RecipientNotLogged.ordinal())
			return "Message Error - Recipient not logged";
		if (value == TI_ERROR_RecipientNoRights.ordinal())
			return "Message Error - Recipient Messaging Disabled";
		if (value == TI_ERROR_SenderNotAllowed.ordinal())
			return "Message Error - Messaging Disabled";
		if (value == TI_ERROR_CCPEligibleFlagMustBeYes.ordinal())
			return "Default Bond must be CCP Eligible";
		if (value == TI_ERROR_WrongChatIdRequest.ordinal())
			return "Mismatch Error - Wrong Message ID";
		if (value == TI_ERROR_SenderNotOwner.ordinal())
			return "Mismatch Error - Wrong Member ID for Message";
		if (value == TI_ERROR_TxnExpired.ordinal())
			return "Message Error - Message already closed";
		if (value == TI_ERROR_WrongMemberType.ordinal())
			return "Message Error - Message not permitted";
		if (value == TI_ERROR_WrongRefTxn.ordinal())
			return "Mismatch Error - Wrong Transaction ID for Message";
		if (value == TI_ERROR_SenderNotAllowedOnRefTxn.ordinal())
			return "Mismatch Error - Wrong Member ID for Message";
		if (value == TI_ERROR_ChatClosed.ordinal())
			return "Message Error - Message Session already closed";
		if (value == TI_ERROR_TxnFinalState.ordinal())
			return "Message Error - Message Session already closed";
		if (value == TI_ERROR_ClosingMessagePresent.ordinal())
			return "Message Error - Message Session already closed";
		if (value == TI_ERROR_CloginMsgNotAllowedForChat.ordinal())
			return "Mismatch Error - Wrong Message Action";
		if (value == TI_ERROR_TxnNotFinalState.ordinal())
			return "Message Error - Message cannot be closed yet";
		if (value == TI_ERROR_BlockedMemberMissing.ordinal())
			return "Input Error - Incomplete Field";
		if (value == TI_ERROR_InvalidBilateralFlag.ordinal())
			return "Input Error - Invalid selection, bilateral trading not allowed";
		if (value == TI_ERROR_WrongMsgId.ordinal())
			return "Mismatch Error - Wrong OTC ID";
		if (value == TI_ERROR_BilateralTradingNotAllowed.ordinal())
			return "Trading Error - Bilateral trading cut-off elapsed";
		if (value == TI_ERROR_RFQExclusion.ordinal())
			return "RFQ Error - Recipient has disabled RFQs";
		if (value == TI_ERROR_DefaultGCInvalid.ordinal())
			return "GC Error- Default Bond for auto allocation must be defined first";
		if (value == TI_ERROR_RepoGCQuantityLimitNotFound.ordinal())
			return "Internal Error - Repo GC Quantity Limit Not Found";
		if (value == TI_ERROR_AccountNotActive.ordinal())
			return "Mismatch Error - Invalid Account";
		if (value == TI_ERROR_MarketParameterNotFound.ordinal())
			return "Internal Error - Market Parameter Not Found";
		if (value == TI_ERROR_OriginatorTraderNotFound.ordinal())
			return "Input Error - Incomplete Field";
		if (value == TI_ERROR_CounterpartTraderNotFound.ordinal())
			return "Input Error - Incomplete Field";
		if (value == TI_ERROR_WrongSubmitter.ordinal())
			return "Input Error - Invalid Counterparty";
		if (value == TI_ERROR_MaxNumberSecurityLimitGC.ordinal())
			return "Allocation Error - Number of tickets exceeds rules of allocation";
		if (value == TI_ERROR_OutLimitsAllocationQtyGC.ordinal())
			return "Allocation Error - Maximum Number of tickets exceeded";
		if (value == TI_ERROR_InvalidSettlementMode.ordinal())
			return "Configuration Error - Invalid Settlement group configuration";
		if (value == TI_ERROR_InvalidTransparentFlag.ordinal())
			return "Input Error - Invalid Flag Integer";
		if (value == TI_ERROR_DailyInflationRateNotFound.ordinal())
			return "Daily inflation rate not found";
		if (value == TI_ERROR_InvalidAllocationTotalQuantity.ordinal())
			return "Pre allocation total quantity different from RFCQ quantity";
		if (value == TI_ERROR_InvalidAllocationStatus.ordinal())
			return "Invalid allocation status";
		if (value == TI_ERROR_AllocationCodeAlreadyPresent.ordinal())
			return "Allocation code already present";
		if (value == TI_ERROR_AllocationNotFound.ordinal())
			return "Pre allocation not found";
		if (value == TI_ERROR_InvalidRecipientForTxn.ordinal())
			return "Mismatch Error - Wrong Member ID";
		if (value == TI_ERROR_InvalidRecipientTraderForTxn.ordinal())
			return "Mismatch Error - Wrong Member ID";
		if (value == TI_ERROR_CCPNotAvailableForInstrument.ordinal())
			return "Input Error - instrument may only be traded bilaterally";
		if (value == TI_ERROR_MaxSellSideNumberExceeded.ordinal())
			return "Max number of sell side members exceeded";
		if (value == TI_ERROR_AllRFCQTypeExcluded.ordinal())
			return "Cannot exclude all RFCQ types with an accepted trading relation";
		if (value == TI_ERROR_QuoteYldAskLowerThanBid.ordinal())
			return "Quote Error - Ask quote is lower than Bid quote";
		if (value == TI_ERROR_InvalidAllocationVerb.ordinal())
			return "Pre allocation side different from RFCQ side";
		if (value == TI_ERROR_ExceptionsLimitExceeded.ordinal())
			return "Exceptions limit exceeded";
		if (value == TI_ERROR_RFCQDoubleSideNotEnabled.ordinal())
			return "RFCQ Double Side - Member not enabled";
		if (value == TI_ERROR_InvalidTradingList.ordinal())
			return "Invalid trading list";
		if (value == TI_ERROR_InvalidTradingListLeg.ordinal())
			return "Trading list - Invalid Leg ID";
		if (value == TI_ERROR_TradingListNotFound.ordinal())
			return "Trading list not found";
		if (value == TI_ERROR_TradingListLegNotFound.ordinal())
			return "Trading list leg not found";
		if (value == TI_ERROR_TradingListWrongMember.ordinal())
			return "Mismatch Error - Wrong Member ID in trading list";
		if (value == TI_ERROR_TradingListWrongTrader.ordinal())
			return "Mismatch Error - Wrong Trader ID in trading list";
		if (value == TI_ERROR_TradingListInvalidStatus.ordinal())
			return "Trading list - Invalid status";
		if (value == TI_ERROR_TradingListInvalidLegStatus.ordinal())
			return "Trading list - Invalid leg status";
		if (value == TI_ERROR_TradingListInvalidLegs.ordinal())
			return "Trading list - Invalid leg";
		if (value == TI_ERROR_StageOrderInTradingList.ordinal())
			return "Stage Order - Cannot modify Stage Order in Trading List";
		if (value == TI_ERROR_StageOrderUsedInTradingList.ordinal())
			return "Stage Order - Stage Order already used in Trading List";
		if (value == TI_ERROR_InvalidRfcqDueInTime.ordinal())
			return "Invalid Rfcq DueInTime";
		if (value == TI_ERROR_InvalidIOI.ordinal())
			return "Number of quotes for auto-match inconsistent";
		if (value == TI_ERROR_TradingListInvalidLegQty.ordinal())
			return "Trading list - Invalid leg quantity";
		if (value == TI_ERROR_TradingListInvalidTotalQty.ordinal())
			return "Trading list - Invalid total quantity";
		if (value == TI_ERROR_TradingListInvalidNumOfLegs.ordinal())
			return "Trading list - Invalid number of legs";
		if (value == TI_ERROR_TradingListWrongInstrType.ordinal())
			return "Trading list - Wrong instrument type";
		if (value == TI_ERROR_DiscloseIOIMismatchingFlags.ordinal())
			return "Disclose and quotation flags mismatching";
		if (value == TI_ERROR_StageOrderWrongLinkIdInTradingList.ordinal())
			return "Stage Order - Inconsistent link ID";
		if (value == TI_ERROR_TradingListInvalidLink.ordinal())
			return "Trading list - Invalid private allocation link";
		if (value == TI_ERROR_InvalidAllocationId.ordinal())
			return "Invalid allocation ID";
		if (value == TI_ERROR_ExchangeRateNotFound.ordinal())
			return "Exchange rate not found";
		if (value == TI_ERROR_FirmQuotingDisabled.ordinal())
			return "Firm quotation disabled";
		if (value == TI_ERROR_IndicativeQuotingDisabled.ordinal())
			return "Indicative quotation disabled";
		if (value == TI_ERROR_StrikerQuotingDisabled.ordinal())
			return "Striker quotation disabled";
		if (value == TI_ERROR_InvalidStrikerQuotationFlag.ordinal())
			return "Quote Error - Invalid striker quotation flag";
		if (value == TI_ERROR_QuoteInvalidStrikerPrice.ordinal())
			return "Quote Error - Invalid striker Price";
		if (value == TI_ERROR_InvalidStrikerPriceRange.ordinal())
			return "Invalid striker Price Range";
		if (value == TI_ERROR_QuoteInvalidStrikerYield.ordinal())
			return "Quote Error - Invalid striker yield";
		if (value == TI_ERROR_InvalidStrikerQty.ordinal())
			return "Invalid striker quantity";
		if (value == TI_ERROR_MidPriceFASTotalQtyUnderLimit.ordinal())
			return "FAS Order total quantity less than minimum size";
		if (value == TI_ERROR_MidPriceFASMinExQtyUnderLimit.ordinal())
			return "FAS Order min execution quantity less than minimum size";
		if (value == TI_ERROR_MidPriceFASTotalQtyUnderMES.ordinal())
			return "FAS Order total quantity less than min execution quantity";
		if (value == TI_ERROR_MidPriceFASTotalQtyNotMultiple.ordinal())
			return "FAS Order total quantity is not a multiple of Min Increment Size";
		if (value == TI_ERROR_MidPriceFASMinExQtyNotMultiple.ordinal())
			return "FAS Order min exec qty is not a multiple of Min Increment Size";
		if (value == TI_ERROR_MidPriceMaximumFASOrderExceeded.ordinal())
			return "Maximum number of FAS Order exceeded";
		if (value == TI_ERROR_MidPriceFASOrderWrongImage.ordinal())
			return "Wrong FAS Order Image";
		if (value == TI_ERROR_MidPriceFASOrderOverlap.ordinal())
			return "FAS Order - Overlapping";
		if (value == TI_ERROR_MidPriceFASOrderInvalidLimitQuotation.ordinal())
			return "FAS Order - Invalid limit quotation";
		if (value == TI_ERROR_MidPriceFOKOrderSectionNotEnabled.ordinal())
			return "FOK Order - Section not enabled";
		if (value == TI_ERROR_InventoryGroupMemberInvalidComb.ordinal())
			return "Inventory group member invalid combination";
		if (value == TI_ERROR_MaxNumberOfMemberInAGroup.ordinal())
			return "Max number of buy side member in a group exceeded";
		if (value == TI_ERROR_MaxNumberOfInvGroupConfig.ordinal())
			return "Max number of inventory group member configuration exceeded";
		if (value == TI_ERROR_MaxNumberOfInvGroupExceptions.ordinal())
			return "Max number of inventory group exceptions exceeded";
		if (value == TI_ERROR_MaxNumberOfInvDealerGroupConfig.ordinal())
			return "Max number of inventory dealer group configuration exceeded";
		if (value == TI_ERROR_InvalidMinExecQty.ordinal())
			return "Invalid minimum execution quantity";
		if (value == TI_ERROR_DenialCounterParty.ordinal())
			return "Exe Order stop - min time between same orders applied";
		if (value == TI_ERROR_InventoryQuoteIsOnlyIndicative.ordinal())
			return "Executable Order - Inventory quote not executable";
		if (value == TI_ERROR_InventoryOrderProcessing.ordinal())
			return "Executable Order - Previous order still processing";
		if (value == TI_ERROR_MidPriceFASMinExQtyOverCapLimit.ordinal())
			return "FAS Order Min Executable Quantity above cap of Min Qty";
		if (value == TI_ERROR_InvalidAxedBondFlags.ordinal())
			return "Quote Error - Axe flag allowed only in bid or ask";
		if (value == TI_ERROR_BrokerCodeNotFound.ordinal())
			return "OTC: brokerage organization code not found";
		if (value == TI_ERROR_BrokerCodeNotCompliant.ordinal())
			return "OTC: broker code not compliant";
		if (value == TI_ERROR_AuthenticationFailed.ordinal())
			return "Authentication Failed";
		if (value == TI_ERROR_BuySideAccountExcluded.ordinal())
			return "Account Excluded By Buy Side Member";
		if (value == TI_ERROR_BrokerCodeInvalidEdit.ordinal())
			return "OTC: broker code can not be modified";
		if (value == TI_ERROR_MaxNumACMCashOfferExceeded.ordinal())
			return "Max number of Cash Offer exceeded";
		if (value == TI_ERROR_MaxNumACMCollateralOfferExceeded.ordinal())
			return "Max number of Collateral Offer exceeded";
		if (value == TI_ERROR_ACMCashOfferNotFound.ordinal())
			return "Cash Offer not found";
		if (value == TI_ERROR_ACMCollateralOfferNotFound.ordinal())
			return "Collateral Offer not found";
		if (value == TI_ERROR_WrongTransactionImage.ordinal())
			return "Wrong Transaction Image";
		if (value == TI_ERROR_ACMCashOfferQtyExceeded.ordinal())
			return "Collateral Offer Quantity exceeds Cash Offer Quantity";
		if (value == TI_ERROR_OnlyFromBrokerPlus.ordinal())
			return "Only BrokerPlus is allowed for this action";
		if (value == TI_ERROR_DisablingNotAllowed.ordinal())
			return "Disabling not allowed for this message";
		if (value == TI_ERROR_EoiMsgTypeUnkown.ordinal())
			return "Invalid EOI Message Type";
		if (value == TI_ERROR_NoRecipientAllowed.ordinal())
			return "No recipient allowed on this section/instrument";
		if (value == TI_ERROR_NoReferencedMsg.ordinal())
			return "Referenced message not found";
		if (value == TI_ERROR_OnlyOneRecipient.ordinal())
			return "Only one recipient is allowed in response";
		if (value == TI_ERROR_EoiMsgCancelled.ordinal())
			return "Referenced message was cancelled";
		if (value == TI_ERROR_EoiMsgNotActive.ordinal())
			return "Referenced message not active";
		if (value == TI_ERROR_DataFeedNotAllowed.ordinal())
			return "Datafeed not allowed for this message/action";
		if (value == TI_ERROR_EoiGenericNotBlind.ordinal())
			return "Generic Eoi cannot be blind";
		if (value == TI_ERROR_StageOrderPartiallyFilled.ordinal())
			return "Stage Order - Partial fill not allowed";
		if (value == TI_ERROR_BVBestGroupAlreadyPresent.ordinal())
			return "BV Best Group Definition already present";
		if (value == TI_ERROR_BVBestSellSideAlreadyPresent.ordinal())
			return "BV Best Group Definition for sellside already present";
		if (value == TI_ERROR_MTSCertificationNotAllowed.ordinal())
			return "MTS Certification only possible by trader config";
		if (value == TI_ERROR_ActivationAllowedWithCertification.ordinal())
			return "Activation only allowed together with certification";
		if (value == TI_ERROR_FirstNameEmpty.ordinal())
			return "First Name cannot be empty";
		if (value == TI_ERROR_LastNameEmpty.ordinal())
			return "Last Name cannot be empty";
		if (value == TI_ERROR_EmailEmpty.ordinal())
			return "Email cannot be empty";
		if (value == TI_ERROR_PhoneEmpty.ordinal())
			return "Phone cannot be empty";
		if (value == TI_ERROR_ResidualMaturityNotFound.ordinal())
			return "Residual maturity not found";
		if (value == TI_ERROR_PriceOrYieldMandatory.ordinal())
			return "Price or Yield must be mandatory";
		if (value == TI_ERROR_ACMUnivocityAccountViolated.ordinal())
			return "Univocity cash offer account violated";
		if (value == TI_ERROR_ACMCollateralOfferBalanceExceeded.ordinal())
			return "Collateral Offer balance exceeded";
		if (value == TI_ERROR_ACMCashOfferBalanceExceeded.ordinal())
			return "Cash Offer balance exceeded";
		if (value == TI_ERROR_AccountMandatory.ordinal())
			return "Missing Account for current transaction";
		if (value == TI_ERROR_AccountException.ordinal())
			return "Found Member Account exception";
		if (value == TI_ERROR_InvalidAccountType.ordinal())
			return "Invalid Account Type";
		if (value == TI_ERROR_EmptyNote.ordinal())
			return "Note field cannot be empty";
		if (value == TI_ERROR_TripartyNoteNotFound.ordinal())
			return "Repo ACM Triparty Note not found";
		if (value == TI_ERROR_WrongTriparty.ordinal())
			return "Triparty id not found";
		if (value == TI_ERROR_CounterpartyNotAccountOwner.ordinal())
			return "Counterparty not owner of account";
		if (value == TI_ERROR_ActionNotAllowedInCurrentDate.ordinal())
			return "Action not allowed in the current date";
		if (value == TI_ERROR_InvalidTradingType.ordinal())
			return "Invalid Trading Type";
		if (value == TI_ERROR_InvalidAreaCode.ordinal())
			return "Invalid Area Code";
		if (value == TI_ERROR_CounterpartyMandatory.ordinal())
			return "Counterparty is mandatory";
		if (value == TI_ERROR_PeriodNotInMarketOpen.ordinal())
			return "Period not in market open plus delay";
		if (value == TI_ERROR_NoPairFoundSectionIC.ordinal())
			return "No pair exists with this section and instrumentClass";
		if (value == TI_ERROR_InvalidFixingTime.ordinal())
			return "Invalid fixing period time";
		if (value == TI_ERROR_InvalidFixingDate.ordinal())
			return "Invalid fixing period date";
		if (value == TI_ERROR_InvalidActionFixingInterval.ordinal())
			return "Invalid action for fixing interval in execution";
		if (value == TI_ERROR_ExpiredFixingInterval.ordinal())
			return "Expired fixing interval";
		if (value == TI_ERROR_StageOrderExecNotAllowed.ordinal())
			return "Stage Order Execution not allowed";
		if (value == TI_ERROR_WildCardExisting.ordinal())
			return "Specific setting not allowed while wildcard existing";
		if (value == TI_ERROR_InvalidMarkUpValue.ordinal())
			return "MarkUpValue not compliant with tick";
		if (value == TI_ERROR_InvalidFieldForTradingModality.ordinal())
			return "Invalid field value for this trading modality";
		if (value == TI_ERROR_UnseasonedNotEnabled.ordinal())
			return "Unseasoned not enabled";
		if (value == TI_ERROR_Section_Dates_Suspended.ordinal())
			return "Trade dates suspended on this section";
		if (value == TI_ERROR_Section_InstClass_Dates_Suspended.ordinal())
			return "Trade dates suspended on this instrument class and section";
		if (value == TI_ERROR_InvalidRateRange.ordinal())
			return "Invalid Rate Range";
		if (value == TI_ERROR_InvalidRateTick.ordinal())
			return "Invalid Rate Tick";
		if (value == TI_ERROR_QuoteInvalidRate.ordinal())
			return "Quote Error - Invalid Rate";
		if (value == TI_ERROR_QuoteRateAskLowerThanBid.ordinal())
			return "Quote Error - Ask rate is lower than Bid rate";
		if (value == TI_ERROR_InvalidTradableObject.ordinal())
			return "Invalid tradable object";
		if (value == TI_ERROR_InvalidSectionForTradableObject.ordinal())
			return "Invalid pair section and tradable object ";
		if (value == TI_ERROR_InvalidICForTradableObject.ordinal())
			return "Invalid pair instrument class and tradable object ";
		if (value == TI_ERROR_MnemonicAlreadyExists.ordinal())
			return "Mnemonic already exists";
		if (value == TI_ERROR_SponsorRelationNotFound.ordinal())
			return "Member and Client specified are not in sponsor relationship";
		if (value == TI_ERROR_FirstDealerNotPreferred.ordinal())
			return "First dealer in list is not the preferred dealer";
		if (value == TI_ERROR_MaxDealersExcedeed.ordinal())
			return "Num of dealers exceeds maximum";
		if (value == TI_ERROR_RecordNotFound.ordinal())
			return "Record not found";
		if (value == TI_ERROR_RecordAlreadyPresent.ordinal())
			return "Record already present";
		if (value == TI_ERROR_AreaCodeRelNotFound.ordinal())
			return "AreaCodeRelation not found";
		if (value == TI_ERROR_MinSellSideNumberNotReached.ordinal())
			return "Min number of sell side members not reached";
		if (value == TI_ERROR_DealerNotAllowedOnRFCQRespond.ordinal())
			return "Dealer not allowed on rfcq respond";
		if (value == TI_ERROR_InvalidNumOfDealers.ordinal())
			return "Num of dealers declared different from dealers list";
		if (value == TI_ERROR_ZeroNumOfDealers.ordinal())
			return "Num of dealers cannot be zero";
		if (value == TI_ERROR_MinimumDealersUnreached.ordinal())
			return "Minimum number of dealers not reached";
		if (value == TI_ERROR_MinMatchingQuotesNotReached.ordinal())
			return "Minimum number of Matching Quotes not reached";
		if (value == TI_ERROR_NoDealerInPreferredList.ordinal())
			return "No dealer in Preferred list";
		if (value == TI_ERROR_MaxReactivationReached.ordinal())
			return "Max number of change profile type reached";
		if (value == TI_ERROR_InvalidProfileType.ordinal())
			return "Profile type not recognized";
		if (value == TI_ERROR_InstrumentClassExists.ordinal())
			return "Configuration for instrument class exists";
		if (value == TI_ERROR_WildCardExists.ordinal())
			return "Configuration with wildcard exists";
		if (value == TI_ERROR_WrongSubmitterMember.ordinal())
			return "Invalid Submitter Member Id";
		if (value == TI_ERROR_WrongDuration.ordinal())
			return "Wrong Duration";
		if (value == TI_ERROR_GroupIdNotFound.ordinal())
			return "Group id not found";
		if (value == TI_ERROR_MaxNumTierGroupConfigurations.ordinal())
			return "Max num tier group configuration reached";
		if (value == TI_ERROR_MaxNumTierGroupException.ordinal())
			return "Max num tier group exception reached";
		if (value == TI_ERROR_WrongCVA.ordinal())
			return "Wrong CVA";
		if (value == TI_ERROR_MemberNotEnableToOverrideCVA.ordinal())
			return "Member not enabled to override CVA";
		if (value == TI_ERROR_WrongTPAVisibility.ordinal())
			return "TPA Visibility not permitted";
		if (value == TI_ERROR_TradingOnBehalfNotAllowed.ordinal())
			return "Trading on behalf not allowed";
		if (value == TI_ERROR_GreaterInventoryVisibleQty.ordinal())
			return "Inventory Quote Error - VisibleQty greater than TotQty";
		if (value == TI_ERROR_CertificationWithoutMnemonic.ordinal())
			return "TPA member certification not allowed without mnemonic";
		if (value == TI_ERROR_TierGroupAssociatedToTPA.ordinal())
			return "Tier Group is associated to TPA Member";
		if (value == TI_ERROR_MaxNumOfTradingIdeaExceeded.ordinal())
			return "Not Used";
		if (value == TI_ERROR_VisibleQtyNotMultiple.ordinal())
			return "Visible Size is not a multiple of Min Increment Size";
		if (value == TI_ERROR_TradableObjectDuplicated.ordinal())
			return "Standard tradable object already exists";
		if (value == TI_ERROR_MaxNumOfBrokenDatesExceeded.ordinal())
			return "Maximum number of Broken Dates exceeded";
		if (value == TI_ERROR_InstClassSectionMktSuspended.ordinal())
			return "Instrument class suspended on this section";
		if (value == TI_ERROR_CAPQuantityLimit.ordinal())
			return "Quantity is greater than CAP Quantity Limit";
		if (value == TI_ERROR_InvalidMarkUpType.ordinal())
			return "Invalid Mark-Up Type";
		if (value == TI_ERROR_MissingMaxQtyZero.ordinal())
			return "Missing Max Quantity value zero for Mark-Up Threshold";
		if (value == TI_ERROR_InvalidMarkUpConfiguration.ordinal())
			return "Mutually exclusive Mark-Up configuration already present";
		if (value == TI_ERROR_InvalidMarkUpMaxQtyOrder.ordinal())
			return "Invalidy Mark-Up Max Quantity Order";
		if (value == TI_ERROR_NumThresholdDiffFromList.ordinal())
			return "Invalid request: number of treshold declared different from list";
		if (value == TI_ERROR_TransactionNotAllowedOnIC.ordinal())
			return "Transaction not allowed on this instrument class";
		if (value == TI_ERROR_InvalidDRate.ordinal())
			return "Invalid Discount Rate";
		if (value == TI_ERROR_InvalidDRateTick.ordinal())
			return "Invalid Discount Rate Tick";
		if (value == TI_ERROR_InvalidDRateRange.ordinal())
			return "Invalid Discount Rate Range";
		if (value == TI_ERROR_QuoteInvalidDRate.ordinal())
			return "Quote Error - Invalid discount rate";
		if (value == TI_ERROR_QuoteDRateBidLowerThanAsk.ordinal())
			return "Quote Error - Bid discount rate is lower than Ask discount rate";
		if (value == TI_ERROR_DealerNotEnabled.ordinal())
			return "Dealer not enabled";
		if (value == TI_ERROR_BuySideMemberInDealerList.ordinal())
			return "Buy Side Member cannot be included in DealerList";
		if (value == TI_ERROR_MaximumIOIExceeded.ordinal())
			return "Maximum IOI Exceeded";
		if (value == TI_ERROR_WrongIOIImage.ordinal())
			return "Wrong IOI Image";
		if (value == TI_ERROR_RFCQInvalidQty.ordinal())
			return "RFCQ Error - Invalid Quantity";
		if (value == TI_ERROR_RFCQWrongQtyChange.ordinal())
			return "RFCQ Error - Unable to change Quantity";
		if (value == TI_ERROR_WildcardBroker.ordinal())
			return "ProductType and Currency admitted only with wildcard for Broker";
		if (value == TI_ERROR_EmptyDepth.ordinal())
			return "Empty Depth - No dealer available for preview";
		if (value == TI_ERROR_CurveNotFound.ordinal())
			return "Curve Identifier not found";
		if (value == TI_ERROR_IOIClientIdentifierAlreadyPresent.ordinal())
			return "IOI Client Identifier already present";
		if (value == TI_ERROR_MembersNCL.ordinal())
			return "Action not allowed for members with NCL";
		if (value == TI_ERROR_ApplyHaircutFlagNo.ordinal())
			return "Action not allowed for ApplyHaircutFlag No";
		if (value == TI_ERROR_HaircutStatusDeleted.ordinal())
			return "Action not allowed for Haircut in Status Deleted";
		if (value == TI_ERROR_MutuallyExclusiveConfiguration.ordinal())
			return "Mutually Exclusive Configuration already present";
		if (value == TI_ERROR_InvalidHaircutValue.ordinal())
			return "Invalid Haircut Value";
		if (value == TI_ERROR_InvalidHaircutType.ordinal())
			return "Invalid Haircut Type";
		if (value == TI_ERROR_InvalidResMatOnIC.ordinal())
			return "Residual Maturity not allowed for this Instrument class Type";
		if (value == TI_ERROR_InvalidCreditProfile.ordinal())
			return "Invalid Credit Profile";
		if (value == TI_ERROR_InvalidMemberType.ordinal())
			return "Invalid Member Type";
		if (value == TI_ERROR_InvalidMemberTypeCombination.ordinal())
			return "Invalid Member Type Combination";
		if (value == TI_ERROR_InvalidSpreadValue.ordinal())
			return "Invalid Spread Value";
		if (value == TI_ERROR_InvalidHaircutStatus.ordinal())
			return "Invalid Haircut Status";
		if (value == TI_ERROR_QuantityNotEditable.ordinal())
			return "Quantity Not Editable";
		if (value == TI_ERROR_SettlSystemNotEnabledToHaircut.ordinal())
			return "Settlement System not enabled to Haircut functionality";
		if (value == TI_ERROR_InstCurrencyAlreadyPresent.ordinal())
			return "Instrument and Currency trading combination already present";
		if (value == TI_ERROR_WarningMessageOnSize.ordinal())
			return "Transaction size in breach of Warning maximum size constraints";
		if (value == TI_ERROR_BlockingMessageOnSize.ordinal())
			return "Transaction size in breach of Blocking maximum size constraints";
		if (value == TI_ERROR_WarningMessageOnRate.ordinal())
			return "Transaction rate in breach of minimum or maximum rate variance constraints";
		if (value == TI_ERROR_WarningMessageOnSizeAndRate.ordinal())
			return "Transaction Size and Rate in breach of minimum or maximum constraints";
		if (value == TI_ERROR_InvalidAlgoInfoType.ordinal())
			return "Invalid Algo Info Type";
		if (value == TI_ERROR_AlgoInfoChange.ordinal())
			return "MiFID IDs cannot be modified";
		if (value == TI_ERROR_InvalidAlgoInfoShortCode.ordinal())
			return "Invalid Algo Info Short Code";
		if (value == TI_ERROR_InvalidLiquidityProvision.ordinal())
			return "Invalid Liquidity Provision";
		if (value == TI_ERROR_InvalidShortSellingIndicator.ordinal())
			return "Invalid Short Selling Indicator";
		if (value == TI_ERROR_InvalidTradingCapacityId.ordinal())
			return "Invalid Trading Capacity";
		if (value == TI_ERROR_ClientRegistrationNotFound.ordinal())
			return "Invalid Client ID";
		if (value == TI_ERROR_InvalidClientIdentificationType.ordinal())
			return "Invalid Client ID Type";
		if (value == TI_ERROR_InvalidExecID.ordinal())
			return "Invalid Exec ID";
		if (value == TI_ERROR_InvalidInvDecID.ordinal())
			return "Invalid Inv Dec ID";
		if (value == TI_ERROR_InvalidClientID.ordinal())
			return "Invalid Client ID";
		if (value == TI_ERROR_InvalidCapacityClientID.ordinal())
			return "Trading Capacity and Client ID not compatible";
		if (value == TI_ERROR_InvalidQtyRFQLISPostTrade.ordinal())
			return "RFQ Qty must be at least equal to LIS Post-Trade";
		if (value == TI_ERROR_InvalidQtyRFQLISPreTrade.ordinal())
			return "RFQ Qty must be at least equal to LIS Pre-Trade";
		if (value == TI_ERROR_InvalidQtyRFQLISPrePostTrade.ordinal())
			return "The RFQ Qty must be at least equal to the greater value between LIS Pre Trade  ";
		if (value == TI_ERROR_VoiceListDealerAlreadyExist.ordinal())
			return "The Dealer is already present in the Voice Confirmed List";
		if (value == TI_ERROR_VoiceListDeleted.ordinal())
			return "Deleted Voice Confirmed List";
		if (value == TI_ERROR_ProcessedTradeNotEligible.ordinal())
			return "Processed Trade not eligible for selected combination";
		if (value == TI_ERROR_PartialExecutionNotPermitted.ordinal())
			return "Partial execution not permitted";
		if (value == TI_ERROR_UserAlreadyPresent.ordinal())
			return "User already present";
		if (value == TI_ERROR_NoRigthsContactMTS.ordinal())
			return "No rights to make this transaction - Please contact MTS";
		if (value == TI_ERROR_InvalidSettlementInfo.ordinal())
			return "Settlement Info not valid";
		if (value == TI_ERROR_MaxNumRulesExceeded.ordinal())
			return "Maximum number of Auto-execution Rules exceeded";
		if (value == TI_ERROR_InvalidAssetClassEligibilityCriteria.ordinal())
			return "Invalid Asset Class Eligibility Criteria";
		if (value == TI_ERROR_InvalidAssetClassNum.ordinal())
			return "Num of Asset Classes declared different from Asset Class/Sub Section combinati ";
		if (value == TI_ERROR_MaxNumEligibilityCriteriaAssetsExceeded.ordinal())
			return "Maximum number of Eligibility Criteria Assets exceeded";
		if (value == TI_ERROR_MaxNumCurrenciesExceeded.ordinal())
			return "Maximum number of currencies exceeded";
		if (value == TI_ERROR_InvalidCurrencyNum.ordinal())
			return "Num of Currencies declared different from Currency List";
		if (value == TI_ERROR_MaxNumResidualMaturitiesExceeded.ordinal())
			return "Maximum number of Residual Maturities exceeded";
		if (value == TI_ERROR_InvalidResidualMaturityNum.ordinal())
			return "Num of Residual Maturities declared different from Residual Maturity List";
		if (value == TI_ERROR_InvalidDealerSelectionType.ordinal())
			return "Invalid Dealer Selection Type";
		if (value == TI_ERROR_InvalidDealerSelectionCriteria.ordinal())
			return "Invalid Dealer Selection Criteria";
		if (value == TI_ERROR_InvalidAutoExecutionSpreadCriterion.ordinal())
			return "Invalid Auto-Execution Spread Criteria Vs BV Best Criterion";
		if (value == TI_ERROR_InvalidRuleName.ordinal())
			return "Invalid Rule Name";
		if (value == TI_ERROR_InvalidDealerList.ordinal())
			return "Dealers Num and Dealer List Type not compatible";
		if (value == TI_ERROR_ExecRulePriorityInvalidEdit.ordinal())
			return "Execution Rule Priority Invalid Edit";
		if (value == TI_ERROR_InvalidBounds.ordinal())
			return "Upper Bound must be greater than Lower Bound";
		if (value == TI_ERROR_InvalidGroupName.ordinal())
			return "Invalid Group Name";
		if (value == TI_ERROR_AutoExecutionDisabled.ordinal())
			return "Auto Execution Disabled";
		if (value == TI_ERROR_AutoExecutionRulesNotAvailable.ordinal())
			return "Auto Execution Rules Not Available";
		if (value == TI_ERROR_GroupNameEmpty.ordinal())
			return "Group Name cannot be empty";
		if (value == TI_ERROR_GroupNameAlreadyPresent.ordinal())
			return "Group Name Already Present";
		if (value == TI_ERROR_DealerGroupLinkedToAutoExecRule.ordinal())
			return "Action not allowed: The Dealer Group is linked to an Auto-Execution Rule";
		if (value == TI_ERROR_DealerAlreadyPresentInList.ordinal())
			return "The Dealer is already present in the Dealer List";
		if (value == TI_ERROR_RuleNameEmpty.ordinal())
			return "Rule Name cannot be empty";
		if (value == TI_ERROR_RuleNameAlreadyPresent.ordinal())
			return "Rule Name Already Present";
		if (value == TI_ERROR_InvalidAssetClassSubSectionComb.ordinal())
			return "Invalid Asset Class/Sub Section combination";
		if (value == TI_ERROR_InvalidSubSectionEligibilityCriteria.ordinal())
			return "Invalid Sub Section Eligibility Criteria";
		if (value == TI_ERROR_ResMatLowerBoundNotFound.ordinal())
			return "Residual Maturity LowerBound not found";
		if (value == TI_ERROR_ResMatUpperBoundNotFound.ordinal())
			return "Residual Maturity UpperBound not found";
		if (value == TI_ERROR_InvalidSizeLimit.ordinal())
			return "Invalid Size Limit";
		if (value == TI_ERROR_ResidualMaturityInvalidBounds.ordinal())
			return "ResidualMaturity: Upper Bound must be greater than Lower Bound";
		if (value == TI_ERROR_SizeInvalidBounds.ordinal())
			return "Size: Upper Bound must be greater than Lower Bound";
		if (value == TI_ERROR_DV01InvalidBounds.ordinal())
			return "DV01: Upper Bound must be greater than Lower Bound";
		if (value == TI_ERROR_InvalidDealerGroupDealerSelTypeComb.ordinal())
			return "Invalid Dealer Group/DealerSelectionType combination";
		if (value == TI_ERROR_DealerGroupEmpty.ordinal())
			return "Dealer Group Id cannot be empty";
		if (value == TI_ERROR_InvalidDealerHitRate.ordinal())
			return "Invalid Dealer Hit Rate";
		if (value == TI_ERROR_InvalidDealerPickupRate.ordinal())
			return "Invalid Dealer Pickup Rate";
		if (value == TI_ERROR_InvalidNegotiationTimes.ordinal())
			return "Max Negotiation Time must be greater than Min Negotiation Time";
		if (value == TI_ERROR_InvalidSpreadQuoteCMFBest.ordinal())
			return "Invalid Spread between quote and CMF Best";
		if (value == TI_ERROR_InvalidSpreadQuoteBVBest.ordinal())
			return "Invalid Spread between quote and BV Best";
		if (value == TI_ERROR_InvalidWideSpread.ordinal())
			return "Invalid Wide Spread";
		if (value == TI_ERROR_InvalidSelMinDealersVsExecMinDealer.ordinal())
			return "Minimum Number of Dealers who must respond to RFQ must be less than or equal t ";
		if (value == TI_ERROR_InvalidMaximumDealerVsSelMinDealers.ordinal())
			return "Minimum Number of Dealers RFQ must be sent to must be less than or equal to Ma ";
		if (value == TI_ERROR_InvalidMaximumDealerVsDealerRotation.ordinal())
			return "Maximum Number of Dealers RFQ can be sent to must be greater than or equal to  ";
		if (value == TI_ERROR_InvalidMaximumDealerVsExecMinDealer.ordinal())
			return "Minimum Number of Dealers who must respond to RFQ must be less than or equal t ";
		if (value == TI_ERROR_MaximumDealerNotAdmitted.ordinal())
			return "Field Maximum Number of Dealers RFQ can be sent to is not admitted";
		if (value == TI_ERROR_AlwaysBeatCMFBestCombNotAdmitted.ordinal())
			return "Execution vs. Benchmark - MTS Interdealer Cash Market, criteria combination no ";
		if (value == TI_ERROR_AlwaysBeatBVBestCombNotAdmitted.ordinal())
			return "Execution vs. Benchmark - BondVision Best, criteria combination not permitted";
		if (value == TI_ERROR_NonCompetitiveQtyExceeded.ordinal())
			return "Non-competitive Qty Exceeded";
		if (value == TI_ERROR_BondSuspendedDueToLackCouponRate.ordinal())
			return "Action not allowed: Bond automatically suspended due to the lack of current Co ";
		if (value == TI_ERROR_MaxNumExecTradersExceeded.ordinal())
			return "Maximum number of Exec Traders exceeded";
		if (value == TI_ERROR_NumExecTradersDiffFromList.ordinal())
			return "Num of Exec Traders declared different from Exec Traders List";
		if (value == TI_ERROR_InvalidDealerRotationNumber.ordinal())
			return "Dealer Group Number must be greater than zero";
		if (value == TI_ERROR_InvalidStageOrderClearingAgentId.ordinal())
			return "Invalid Stage Order Clearing Agent Id";
		if (value == TI_ERROR_EditHaircutNotAllowed.ordinal())
			return "Edit Haircut not allowed";
		if (value == TI_ERROR_InvalidOverriddenSpotPrice.ordinal())
			return "Invalid Overridden Spot Price";
		if (value == TI_ERROR_InvalidInstrumentType.ordinal())
			return "Invalid Instrument Type";
		if (value == TI_ERROR_InvalidNote.ordinal())
			return "Invalid Note";
		if (value == TI_ERROR_InvalidAccountTypeExecType.ordinal())
			return "Account Type and Execution Type are not compatible";
		if (value == TI_ERROR_InvalidOrderTypeLimitRate.ordinal())
			return "Order Type and Limit Rate are not compatible";
		if (value == TI_ERROR_InvalidEndDateModifyFgExecType.ordinal())
			return "End Date Modify Flag and Execution Type are not compatible";
		if (value == TI_ERROR_InvalidNoPartialFillFgExecType.ordinal())
			return "No Partial Fill Flag and Execution Type are not compatible";
		if (value == TI_ERROR_InvalidApplyHaircutFgExecType.ordinal())
			return "Apply Haircut Flag and Execution Type are not compatible";
		if (value == TI_ERROR_InvalidTradModalityExecType.ordinal())
			return "Execution Type not supported by the Trading Modality for the Instrument Class/ ";
		if (value == TI_ERROR_OtcRegUTINotAllowed.ordinal())
			return "OTC Registration - UTI value not allowed";
		if (value == TI_ERROR_OtcRegUTIChangeNotAllowed.ordinal())
			return "OTC Registration - UTI value modification not allowed";
		if (value == TI_ERROR_OtcRegRTNNotAllowed.ordinal())
			return "OTC Registration - RTN value not allowed";
		if (value == TI_ERROR_OtcRegRTNChangeNotAllowed.ordinal())
			return "OTC Registration - RTN value modification not allowed";
		if (value == TI_ERROR_ReportSubmittingEntityInvalidFormat.ordinal())
			return "Report Submitting Entity - format not allowed";
		if (value == TI_ERROR_ReportingCounterpartyInvalidFormat.ordinal())
			return "Reporting Counterparty - format not allowed";
		if (value == TI_ERROR_ReportResponsibleEntityInvalidFormat.ordinal())
			return "Report Responsible Entity - format not allowed";
		if (value == TI_ERROR_ReportSubmittingEntityMustBeUnique.ordinal())
			return "Report Submitting Entity must be unique per Account";
		if (value == TI_ERROR_ReportingCounterpartyMustBeUnique.ordinal())
			return "Reporting Counterparty must be unique per Account";
		if (value == TI_ERROR_ReportResponsibleEntityMustBeUnique.ordinal())
			return "Report Responsible Entity must be unique per Account";
		if (value == TI_ERROR_SectorAlreadyPresent.ordinal())
			return "Sector already present in list";
		if (value == TI_ERROR_SectorNotFound.ordinal())
			return "Sector not found";
		if (value == TI_ERROR_AdditionalSectorClassificationNotFound.ordinal())
			return "Additional Sector Classification not found";
		if (value == TI_ERROR_CountryNotFound.ordinal())
			return "Country not found";
		if (value == TI_ERROR_BranchCountryNotFound.ordinal())
			return "Branch Country not found";
		if (value == TI_ERROR_BeneficiaryInvalidFormat.ordinal())
			return "Beneficiary - format not allowed";
		if (value == TI_ERROR_AgentLenderInvalidFormat.ordinal())
			return "AgentLender - format not allowed";
		if (value == TI_ERROR_MasterAgreementTypeNotFound.ordinal())
			return "Master Agreement Type not found";
		if (value == TI_ERROR_OtherMasterAgreementTypeInvalidComb.ordinal())
			return "Other Master Agreement Type invalid combination";
		if (value == TI_ERROR_MasterAgreementVersionInvalidFormat.ordinal())
			return "Master Agreement Version - format not allowed";
		if (value == TI_ERROR_ClearingMemberInvalidFormat.ordinal())
			return "Clearing Member - format not allowed";
		if (value == TI_ERROR_CSDParticipantInvalidFormat.ordinal())
			return "CSD Participant - format not allowed";
		if (value == TI_ERROR_ClearingMemberMustBeUnique.ordinal())
			return "Clearing Member Entity must be unique per Account";
		if (value == TI_ERROR_CSDParticipantMustBeUnique.ordinal())
			return "CSD Participant must be unique per Account";
		if (value == TI_ERROR_MemberProfileMustComplyD2C.ordinal())
			return "Member profile must comply with D2C Requirement";
		if (value == TI_ERROR_OpenTradesRequiresManualSett.ordinal())
			return "Open Trades requires manual settlement";
		if (value == TI_ERROR_InvalidClientShortCode.ordinal())
			return "Invalid Client Short Code";
		if (value == TI_ERROR_InvalidDealerClientRelationshipStatus.ordinal())
			return "Invalid Dealer Client Relationship Status";
		if (value == TI_ERROR_InvalidVerbForGCTradingDealerClient.ordinal())
			return "Invalid Verb For GC Trading Dealer Client";
		if (value == TI_ERROR_InvalidLinkIdExecType.ordinal())
			return "Invalid LinkId: cannot be empty with this ExecutionType";
		if (value == TI_ERROR_PortfolioCodeInvalidFormat.ordinal())
			return "PortfolioCode Code - format not allowed";
		if (value == TI_ERROR_ClientShortCodeInvalidFormat.ordinal())
			return "Client Short Code - format not allowed";
		if (value == TI_ERROR_ClientLongCodeInvalidFormat.ordinal())
			return "Client Long Code - format not allowed";
		if (value == TI_ERROR_DefClientTraderNameInvalidFormat.ordinal())
			return "Default Client Trader Name - format not allowed";
		if (value == TI_ERROR_ClientLEICodeInvalidFormat.ordinal())
			return "Client LEI Code - format not allowed";
		if (value == TI_ERROR_AccountClientShortCodeInvalidConfig.ordinal())
			return "Account Id - Client Short Code - Invalid configuration";
		if (value == TI_ERROR_CounterpartyClientShortCodeInvalidConfig.ordinal())
			return "Counterparty Id - Client Short Code - Invalid configuration";
		if (value == TI_ERROR_PlainVanillaNotAllowedForTradingType.ordinal())
			return "Plain Vanilla not allowed for Trading Type";
		if (value == TI_ERROR_TradeDateNotAllowedForTradingType.ordinal())
			return "Trade Date not allowed for Trading Type";
		if (value == TI_ERROR_RateFlagShouldBeEqualBetweenSOAndRFCQ.ordinal())
			return "Rate Flag  - Should be equal between Stage Order and RFCQ";
		if (value == TI_ERROR_DealerListTypeNegativeExeTypeOTC.ordinal())
			return "Dealer List Type cannot be negative with Execution Type OTC";
		if (value == TI_ERROR_DealerListTypeShouldBePosOrNegNumDealer.ordinal())
			return "Dealer List Type should be positive or negative if Number of Dealer > 0";
		if (value == TI_ERROR_NumberOfDealersLowerDefLimit.ordinal())
			return "Number of dealers in the Dealer List cannot be lower than  the defined limit ( ";
		if (value == TI_ERROR_BilOnlyFlagMustAssumeYesCorrSOYes.ordinal())
			return "Bilateral only flag must assume value Yes if the correspondent Stage Order fie ";
		if (value == TI_ERROR_StartDateShouldBeLessEndDate.ordinal())
			return "Start Date should be less than the End Date";
		if (value == TI_ERROR_CutOffExpiredForSettlMod.ordinal())
			return "Cut off expired for the specified settlement modality";
		if (value == TI_ERROR_ClearingAgentCannotDiffOrdersSameLinkId.ordinal())
			return "Clearing Agent cannot differ among orders with the same Link Id";
		if (value == TI_ERROR_AccountIdCannotDiffOrdersSameLinkId.ordinal())
			return "Account Id  cannot differ among orders with the same Link Id";
		if (value == TI_ERROR_ApplyHaircutFgShouldBeEqBetweenRFCQAndSO.ordinal())
			return "Apply Haircut Flag should be equal between RFCQ and Stage Order";
		if (value == TI_ERROR_AlgoInfoDiffPredValues.ordinal())
			return "Algo Info differ from predefined values (SO)";
		if (value == TI_ERROR_ClientIdInfoDiffPredValues.ordinal())
			return "Client Id Info differ from predefined values (SO)";
		if (value == TI_ERROR_BuySellIndCannotDiffSO.ordinal())
			return "Buy/Sell indicator cannot differ from the Stage Order";
		if (value == TI_ERROR_QuantityCannotDiffSO.ordinal())
			return "Quantity cannot differ from the Stage Order";
		if (value == TI_ERROR_SellSideMembersDiffPredOnes.ordinal())
			return "Sell side Members differ from predefined ones (Positive Dealer List on the Sta ";
		if (value == TI_ERROR_CounterpartyDiffPredOne.ordinal())
			return "Counterparty differs from the predefined one (Positive Dealer List on the Stag ";
		if (value == TI_ERROR_AccountIdCannotDiffSO.ordinal())
			return "Account Id cannot differ from the Stage Order";
		if (value == TI_ERROR_ClearingAgentIdDiffSO.ordinal())
			return "Clearing Agent Id cannot differ from the Stage Order";
		if (value == TI_ERROR_MemberProfileNotEnabledToSO.ordinal())
			return "Member Profile not enabled to Stage Orders";
		if (value == TI_ERROR_InvalidDealerClientFg.ordinal())
			return "Invalid DealerClientFg";
		if (value == TI_ERROR_ClientTraderNameInvalidFormat.ordinal())
			return "Client Trader Name - format not allowed";
		if (value == TI_ERROR_DealerClientRelationNotFound.ordinal())
			return "Dealer Client Relation not found";
		if (value == TI_ERROR_DealerClientRelationDeleted.ordinal())
			return "Dealer Client Relation deleted";
		if (value == TI_ERROR_CAPSSettlSystemNotEnabledToCAPS.ordinal())
			return "Settlement System not enabled to CAPS functionality";
		if (value == TI_ERROR_CAPSAlreadyPresent.ordinal())
			return "CAPS already present";
		if (value == TI_ERROR_CAPSInvalidIndirectRelation.ordinal())
			return "Member is not a Direct Member for this Settlement System";
		if (value == TI_ERROR_CAPSRequiresAutomaticSett.ordinal())
			return "CAPS functionality not admitted for manual settlement";
		if (value == TI_ERROR_CAPSInvalidDailyCAPSLimit.ordinal())
			return "Invalid Daily CAPS Limit";
		if (value == TI_ERROR_CAPSLimitExceeded.ordinal())
			return "CAPS Limit Exceeded";
		if (value == TI_ERROR_CAPSLimitNotConfigured.ordinal())
			return "CAPS Limit not configured";
		if (value == TI_ERROR_CAPSLocked.ordinal())
			return "CAPS locked by the Direct Member";
		if (value == TI_ERROR_TradingNotAdmitted.ordinal())
			return "Counterparty not enabled to trade";
		if (value == TI_ERROR_OriginatorCAPSLimitExceeded.ordinal())
			return "Originator CAPS Limit Exceeded";
		if (value == TI_ERROR_OriginatorCAPSLimitNotConfigured.ordinal())
			return "Originator CAPS Limit not configured";
		if (value == TI_ERROR_OriginatorCAPSLocked.ordinal())
			return "Originator CAPS locked by the Direct Member";
		if (value == TI_ERROR_CounterpartCAPSLimitExceeded.ordinal())
			return "Counterpart CAPS Limit Exceeded";
		if (value == TI_ERROR_CounterpartCAPSLimitNotConfigured.ordinal())
			return "Counterpart CAPS Limit not configured";
		if (value == TI_ERROR_CounterpartCAPSLocked.ordinal())
			return "Counterpart CAPS locked by the Direct Member";
		if (value == TI_ERROR_DateDiscrepancyBetweenSOAndTxn.ordinal())
			return "Discrepancy on Start/End Date/Vanilla Id between Stage Order and Transaction";
		if (value == TI_ERROR_SPDiscrepancyBetweenSOAndTransaction.ordinal())
			return "Spot Price discrepancy between Stage Order and Transaction";
		if (value == TI_ERROR_RateDiscrepancyBetweenSOAndTransaction.ordinal())
			return "Rate discrepancy between Stage Order and Transaction";
		if (value == TI_ERROR_TradingListPrivateExecTraderSetInSO.ordinal())
			return "Trading List must be private when the Execution Trader is set in the Stage Ord ";
		if (value == TI_ERROR_SOAlreadyAssociatedToOTCTransaction.ordinal())
			return "Stage Order already associated to an OTC Transaction";
		if (value == TI_ERROR_FieldValueDiscBetweenSOAndRFCQOTC.ordinal())
			return "Field value discrepancy between Stage Order and RFCQ/OTC Transaction";
		if (value == TI_ERROR_FieldValueDiscBetweenSOAndTradingList.ordinal())
			return "Field value discrepancy between Stage Order and Trading List";
		if (value == TI_ERROR_AlgoInfoDiscBetweenSOAndTransaction.ordinal())
			return "Algo Info discrepancy between Stage Order and Transaction";
		if (value == TI_ERROR_MaxNumExecutionTimesExceeded.ordinal())
			return "Maximum number of Execution Times exceeded";
		if (value == TI_ERROR_InvalidExecutionTimesNum.ordinal())
			return "Num of Execution Times declared different from Execution Time List";
		if (value == TI_ERROR_ExecutionTimeNotAdmitted.ordinal())
			return "Execution Time is not admitted for this Execution Type";
		if (value == TI_ERROR_WrongSortingExecutionTimes.ordinal())
			return "Wrong sorting for Execution Times list";
		if (value == TI_ERROR_ExecutionTimesDuplicated.ordinal())
			return "Execution Times Duplicated";
		if (value == TI_ERROR_ExecutionTimeListNotAdmitted.ordinal())
			return "Execution Time List is not admitted";
		if (value == TI_ERROR_ActionNotAllowedExecutionTime.ordinal())
			return "Action not allowed due to not expired Execution Time";
		if (value == TI_ERROR_DirectBuySideMemberAlreadySet.ordinal())
			return "Direct Buy Side Member already set";
		if (value == TI_ERROR_TotalSplitFillMinSizeQty.ordinal())
			return "Quantity less than total Split Fill minimum size";
		if (value == TI_ERROR_IncompatibleSettlModeConfiguration.ordinal())
			return "Incompatible Settlement Mode configuration";
		if (value == TI_ERROR_DefaultExecTraderNotPermitted.ordinal())
			return "Default Auto Execution Trader is not permitted in case of Exec Trader List";
		if (value == TI_ERROR_AutoExecutionInProgress.ordinal())
			return "Action not allowed - Auto Execution still in progress";
		if (value == TI_ERROR_NoBeatLimitPriceDeviation.ordinal())
			return "No Beat Limit Price Deviation has been set";
		if (value == TI_ERROR_InvalidStageOrderClientLimitQuotation.ordinal())
			return "Invalid Stage Order ClientLimitQuotation";
		if (value == TI_ERROR_LimitSpreadNotAllowedByRFCQType.ordinal())
			return "Limit Spread not allowed by the RFCQ Type";
		if (value == TI_ERROR_WrongTradeRegistrationId.ordinal())
			return "Trade Registration Error - Wrong Message Id";
		if (value == TI_ERROR_InvalidDealerOrderId.ordinal())
			return "Invalid DealerOrder ID";
		if (value == TI_ERROR_WrongOriginalDealerOrderId.ordinal())
			return "Wrong Original DealerOrder ID";
		if (value == TI_ERROR_MaxRateCapBreach.ordinal())
			return "Transaction rate in breach of blocking maximum rate constraints";
		if (value == TI_ERROR_MinRateCapBreach.ordinal())
			return "Transaction rate in breach of blocking minimum rate constraints";
		if (value == TI_ERROR_EndDateIdCapBreach.ordinal())
			return "Transaction term in breach of blocking maximum EndDateId constraints";
		if (value == TI_ERROR_DaysCapBreach.ordinal())
			return "Transaction term in breach of blocking maximum Days constraints";
		if (value == TI_ERROR_BuySideMemberNotEnabled.ordinal())
			return "Buy Side Member not Enabled on this Instrument Class";
		if (value == TI_ERROR_LimitSpreadStageOrderNotAllowedByRFCQType.ordinal())
			return "Stage Order with Limit Spread not allowed by the RFCQ Type";
		if (value == TI_ERROR_TooManyInstrument.ordinal())
			return "The same instrument was inserted too many times for this RFQ Type";
		if (value == TI_ERROR_AggregatedStageOrderWithoutSpread.ordinal())
			return "Aggregated Stage Order without Spread Client Quotation Type";
		if (value == TI_ERROR_MemberNotEnabled.ordinal())
			return "Member not Enabled on any Instrument Class";
		if (value == TI_ERROR_EurexAccountAlreadyPresent.ordinal())
			return "Eurex Account already present";
		if (value == TI_ERROR_InvalidEurexMemberId.ordinal())
			return "Eurex Member Id is empty or Contains Invalid Characters";
		if (value == TI_ERROR_InvalidEurexTraderId.ordinal())
			return "Eurex Trader Id is empty or Contains Invalid Characters";
		if (value == TI_ERROR_InvalidEurexAutoApprovalRuleId.ordinal())
			return "Eurex Auto-Approval Rule Id must be greater than or equal to zero";
		if (value == TI_ERROR_InvalidEurexDefaultFlag.ordinal())
			return "Only one Eurex Account can be Member’s the default";
		if (value == TI_ERROR_InvalidEurexAccountId.ordinal())
			return "Eurex Account Invalid";
		if (value == TI_ERROR_InvalidHedgeRatio.ordinal())
			return "Invalid hedge ratio";
		if (value == TI_ERROR_TradeRegistrationBasisInvalidNumOfLegs.ordinal())
			return "Trade Registration Basis - Invalid number of legs";
		if (value == TI_ERROR_MemberNotFoundEurexAccount.ordinal())
			return "Member Not Present in EurexAccount";
		if (value == TI_ERROR_InvalidTradeRegistrationType.ordinal())
			return "Invalid Trade Registration Type";
		if (value == TI_ERROR_MemberNotEnabledToSendRFCQPortfolio.ordinal())
			return "Member not enabled to send RFCQ Portfolio";
		if (value == TI_ERROR_DisabledByGCM.ordinal())
			return "Disabled by GCM";
		if (value == TI_ERROR_ExcededGCMSizeLimit.ordinal())
			return "Exceded GCM Size Limit";
		if (value == TI_ERROR_AmountBothZero.ordinal())
			return "Nominal Amount or 10 Year Equivalent Nominal Amount can not be both equal to z ";
		if (value == TI_ERROR_AmountBothGreaterZero.ordinal())
			return "Nominal Amount or 10 Year Equivalent Nominal Amount can not be both greater th ";
		if (value == TI_ERROR_10YBenchmarkBondNotFound.ordinal())
			return "10-Year Benchmark Bond not configured";
		if (value == TI_ERROR_MaximumRFCQPortfolioExceeded.ordinal())
			return "Maximum number of RFCQ Portfolio exceeded";
		if (value == TI_ERROR_VisibleQtyGreaterMinQty.ordinal())
			return "VisibleQty greater than MinQty";
		if (value == TI_ERROR_PortfolioInvalidNumOfLegs.ordinal())
			return "Portfolio - Invalid number of legs";
		if (value == TI_ERROR_ISINReferenceDataNotAvailable.ordinal())
			return "Invalid ISIN Code - Reference Data Not Available";
		if (value == TI_ERROR_ISINNotMTSCompliantBond.ordinal())
			return "Invalid ISIN Code - Not MTS Compliant Bond";
		if (value == TI_ERROR_ISINExceededDailyMaxNumListableBonds.ordinal())
			return "Invalid ISIN Code - Exceeded daily maximum number of listable bonds";
		if (value == TI_ERROR_ISINExceededListingCutoffTime.ordinal())
			return "Invalid ISIN Code - Exceeded Listing Cut-off Time";
		if (value == TI_ERROR_InvalidCharactersForISINCode.ordinal())
			return "Invalid characters for ISIN Code";
		if (value == TI_ERROR_ISINBondListingProcessing.ordinal())
			return "Invalid ISIN Code - Bond Listing processing";
		if (value == TI_ERROR_InvalidPreviewId.ordinal())
			return "Invalid PreviewId";
		if (value == TI_ERROR_IncompatibleMOCFixingTime.ordinal())
			return "Incompatible MOC Fixing Time";
		if (value == TI_ERROR_IncompatibleMOCCutOffTime.ordinal())
			return "Incompatible MOC Cut Off Time";
		if (value == TI_ERROR_InvalidValueForClosingTypeMOC.ordinal())
			return "Invalid value for Closing Type MOC";
		if (value == TI_ERROR_MOCAcceptanceTimeoutExceedMOCFixingTime.ordinal())
			return "MOC Acceptance Timeout exceed the MOC Fixing Time";
		if (value == TI_ERROR_MOCCutOffTimeExpired.ordinal())
			return "MOC Cut Off Time expired";
		if (value == TI_ERROR_MaxNumListingRequestsExceeded.ordinal())
			return "Maximum number of Listing Requests exceeded";
		if (value == TI_ERROR_ISINAlreadyPresent.ordinal())
			return "Invalid ISIN Code - Already present";
		if (value == TI_ERROR_MemberSalesExceptionInvComb.ordinal())
			return "Member Sales Exception invalid combination";
		if (value == TI_ERROR_InvalidProductType.ordinal())
			return "Invalid Product Type";
		if (value == TI_ERROR_InvalidRatingCategory.ordinal())
			return "Invalid Rating Category";
		return "";
	}
	public static TI_ERROR_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ERROR_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
