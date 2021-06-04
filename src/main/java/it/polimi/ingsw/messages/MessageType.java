package it.polimi.ingsw.messages;

public enum MessageType {
    EXIT,
    OK,
    RESTARTQUESTIONMESSAGE,
    RESTARTANSWERMESSAGE,
    BOOTINGLOBBYERROR,
    COMPLETERUNNINGMATCHERROR,
    MESSAGEFORNPLAYERS,
    PLAYERNUMBER,
    USERNAME,
    ALREADYEXISTINGNICKNAMEERROR,
    NICKNAMENOTFOUNDERROR,
    INITIALRESOURCES,
    PICKEDLEADERCARDS,
    KEEPLEADERCARDS,
    PRODUCTIONON,
    BASEPRODUCTIONON,
    EXTRAPRODUCTIONON,
    DOUBLEEXTRAPRODUCTIONON,
    ALREADYACTIVATEDERROR,
    WRONGCOLUMNERROR,
    NOTAVAILABLERESOURCESERROR,
    ENDOFPRODUCTION,
    PUSHROW,
    PUSHCOLUMN,
    DOUBLEWHITEMARBLEEFFECT,
    WHITEMARBLECHOOSENRESOURCES,
    NOTENOUGHSPACEERROR,
    KEEPRESOURCES,
    DISCARDLEADERCARD,
    ACTIVATELEADERCARD,
    ALREADYUSEDLEADERCARDERROR,
    REQUIREMENTSERROR,
    BUYPRODUCTIONCARD,
    ENDOFTURN,
    CHANGECURRENTPLAYER,
    NOTYOURTURNERROR,
    LASTTURN,
    ENDGAME,
    OPPONENTFAITHMOVE,
    OPPONENTBUYPRODCARD,
    OPPONENTDISCARDLC,
    OPPONENTACTIVATELC,
    SETPAPALS,
    LORENZOSACTION,
    RESERVEVALUE,
    PING,
    PONG,
   /* ****** ********************* */

   DECKPRODUCTIONCARD,
    TAKECARD,
    REMOVECARD,
    CONFIGURATIONMARKET,
    CHANGEMARKETMESSAGECOLUMN,
    CHANGEMARKETMESSAGEROW,
    MAGNIFICENTMOVEMESSAGE,
    MAGNIFICENTWIN,
    MYVICTORY,
    MYDEFEAT,
    USEACTIONMARKER,
    PRODUCTIONUPDATE,
    PRODUCTIONUPDATEFORCURRENT,
    TAKECARDFORNOTCURRENT,
    ACTIVATIONLEADERCARDRESPONSE,
   ACTIVATIONLEADERCARDNOTIFICATION,
    DISCARDLEADERCARDNOTIFICATION ,
    DISCARDLEADERCARDRESPONSE ,
    ENDGAMEWINNER,
    OPPONENTFAITHPATHMOVE,
    MYFAITHMOVE,
    CONFIGURATIONGAMEBOARD,
    PRODUCTIONRESULT,
    RESULTFROMARKET,
    NICKNAME,
    LORENZOCONFIG,
    RESERVEUPDATE,
    UPDATEINITRESOURCE,
    UPDATEINITLEADERCARD,
    UPDATECHOSENLEADERCARD,
    OPPONENTUPDATEINITRESOURCE,
    RESULTFROMARKETNOTCURRENT,
    PRODUCTIONUPDATEFORNOTCURRENT,
    CONFIGURATIONSTRONGBOX,
    CONFIGURATIONSTORAGE,
    CONFIGURATIONSTORAGEEXTRA,
    CONFIGURATIONSTORAGEEXTRADOUBLE,
    LEADERCONFIGMESSAGE,
    MYFAITHMOVECONFIG,
    DECKPRODUCTIONCARDCONFIG,
    TABLEPRODUCTIONCARDCONFIG,
    LORENZOMAGNIFICFAITHMOVE,
    YOURTURN,
    CHANGETURN,
    GAMETYPE,
    USERNAMEAREQUEST,
    INIT,
    ASKINNFO,
    ASKINFO,
    NOTPLAYERSERROR,
    ALLOFPLAYER,
    POSITION,
    BASEPRODUCTIONERROR,
    DISCONNECTIONOPPONENT, PAPALCARDSCONFIG
}
