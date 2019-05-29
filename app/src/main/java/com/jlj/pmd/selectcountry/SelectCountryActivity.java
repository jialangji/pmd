package com.jlj.pmd.selectcountry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.jlj.pmd.R;
import com.jlj.pmd.azlist.AZItemEntity;
import com.jlj.pmd.azlist.AZSideBarView;
import com.jlj.pmd.azlist.AZTitleDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SelectCountryActivity extends AppCompatActivity {
    @BindView(R.id.recyler)
    RecyclerView recyler;
    @BindView(R.id.bar_list)
    AZSideBarView barList;
    private List<AZItemEntity<Country>> dateList = new ArrayList<>();
    private SelectCountryAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);
        ButterKnife.bind(this);
        Gson gson=new Gson();
          gson.fromJson("        {\n" +
                "            \"cnName\": \"阿富汗\",\n" +
                "            \"dialingCode\": \"+93\",\n" +
                "            \"enName\": \"AFGHANISTAN\",\n" +
                "            \"numberCode\": \"4\",\n" +
                "            \"showName\": \"阿富汗(AFGHANISTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿尔巴尼亚\",\n" +
                "            \"dialingCode\": \"+355\",\n" +
                "            \"enName\": \"ALBANIA\",\n" +
                "            \"numberCode\": \"8\",\n" +
                "            \"showName\": \"阿尔巴尼亚(ALBANIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿尔及利亚\",\n" +
                "            \"dialingCode\": \"+213\",\n" +
                "            \"enName\": \"ALGERIA\",\n" +
                "            \"numberCode\": \"12\",\n" +
                "            \"showName\": \"阿尔及利亚(ALGERIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"美属萨摩亚\",\n" +
                "            \"dialingCode\": \"+684\",\n" +
                "            \"enName\": \"AMERICAN SAMOA\",\n" +
                "            \"numberCode\": \"16\",\n" +
                "            \"showName\": \"美属萨摩亚(AMERICAN SAMOA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"安道尔\",\n" +
                "            \"dialingCode\": \"+376\",\n" +
                "            \"enName\": \"ANDORRA\",\n" +
                "            \"numberCode\": \"20\",\n" +
                "            \"showName\": \"安道尔(ANDORRA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"安哥拉\",\n" +
                "            \"dialingCode\": \"+244\",\n" +
                "            \"enName\": \"ANGOLA\",\n" +
                "            \"numberCode\": \"24\",\n" +
                "            \"showName\": \"安哥拉(ANGOLA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"安圭拉岛\",\n" +
                "            \"dialingCode\": \"+1264\",\n" +
                "            \"enName\": \"ANGUILLA\",\n" +
                "            \"numberCode\": \"660\",\n" +
                "            \"showName\": \"安圭拉岛(ANGUILLA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"安提瓜和巴布达\",\n" +
                "            \"dialingCode\": \"+1268\",\n" +
                "            \"enName\": \"ANTIGUA AND BARBUDA\",\n" +
                "            \"numberCode\": \"28\",\n" +
                "            \"showName\": \"安提瓜和巴布达(ANTIGUA AND BARBUDA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿根廷\",\n" +
                "            \"dialingCode\": \"+54\",\n" +
                "            \"enName\": \"ARGENTINA\",\n" +
                "            \"numberCode\": \"32\",\n" +
                "            \"showName\": \"阿根廷(ARGENTINA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"亚美尼亚\",\n" +
                "            \"dialingCode\": \"+374\",\n" +
                "            \"enName\": \"ARMENIA\",\n" +
                "            \"numberCode\": \"51\",\n" +
                "            \"showName\": \"亚美尼亚(ARMENIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"澳大利亚\",\n" +
                "            \"dialingCode\": \"+61\",\n" +
                "            \"enName\": \"AUSTRALIA\",\n" +
                "            \"numberCode\": \"36\",\n" +
                "            \"showName\": \"澳大利亚(AUSTRALIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"奥地利\",\n" +
                "            \"dialingCode\": \"+43\",\n" +
                "            \"enName\": \"AUSTRIA\",\n" +
                "            \"numberCode\": \"40\",\n" +
                "            \"showName\": \"奥地利(AUSTRIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿塞拜疆\",\n" +
                "            \"dialingCode\": \"+994\",\n" +
                "            \"enName\": \"AZERBAIJAN\",\n" +
                "            \"numberCode\": \"31\",\n" +
                "            \"showName\": \"阿塞拜疆(AZERBAIJAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴哈马\",\n" +
                "            \"dialingCode\": \"+1242\",\n" +
                "            \"enName\": \"BAHAMAS\",\n" +
                "            \"numberCode\": \"44\",\n" +
                "            \"showName\": \"巴哈马(BAHAMAS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴林\",\n" +
                "            \"dialingCode\": \"+973\",\n" +
                "            \"enName\": \"BAHRAIN\",\n" +
                "            \"numberCode\": \"48\",\n" +
                "            \"showName\": \"巴林(BAHRAIN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"孟加拉国\",\n" +
                "            \"dialingCode\": \"+880\",\n" +
                "            \"enName\": \"BANGLADESH\",\n" +
                "            \"numberCode\": \"50\",\n" +
                "            \"showName\": \"孟加拉国(BANGLADESH)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴巴多斯\",\n" +
                "            \"dialingCode\": \"+1246\",\n" +
                "            \"enName\": \"BARBADOS\",\n" +
                "            \"numberCode\": \"52\",\n" +
                "            \"showName\": \"巴巴多斯(BARBADOS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"白俄罗斯\",\n" +
                "            \"dialingCode\": \"+375\",\n" +
                "            \"enName\": \"BELARUS\",\n" +
                "            \"numberCode\": \"112\",\n" +
                "            \"showName\": \"白俄罗斯(BELARUS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"比利时\",\n" +
                "            \"dialingCode\": \"+32\",\n" +
                "            \"enName\": \"BELGIUM\",\n" +
                "            \"numberCode\": \"56\",\n" +
                "            \"showName\": \"比利时(BELGIUM)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"伯利兹\",\n" +
                "            \"dialingCode\": \"+501\",\n" +
                "            \"enName\": \"BELIZE\",\n" +
                "            \"numberCode\": \"84\",\n" +
                "            \"showName\": \"伯利兹(BELIZE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"贝宁\",\n" +
                "            \"dialingCode\": \"+229\",\n" +
                "            \"enName\": \"BENIN\",\n" +
                "            \"numberCode\": \"204\",\n" +
                "            \"showName\": \"贝宁(BENIN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"百慕大群岛\",\n" +
                "            \"dialingCode\": \"+1441\",\n" +
                "            \"enName\": \"BERMUDA\",\n" +
                "            \"numberCode\": \"60\",\n" +
                "            \"showName\": \"百慕大群岛(BERMUDA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"玻利维亚\",\n" +
                "            \"dialingCode\": \"+591\",\n" +
                "            \"enName\": \"BOLIVIA, PLURINATIONAL STATE OF\",\n" +
                "            \"numberCode\": \"68\",\n" +
                "            \"showName\": \"玻利维亚(BOLIVIA, PLURINATIONAL STATE OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"博茨瓦纳\",\n" +
                "            \"dialingCode\": \"+267\",\n" +
                "            \"enName\": \"BOTSWANA\",\n" +
                "            \"numberCode\": \"72\",\n" +
                "            \"showName\": \"博茨瓦纳(BOTSWANA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴西\",\n" +
                "            \"dialingCode\": \"+55\",\n" +
                "            \"enName\": \"BRAZIL\",\n" +
                "            \"numberCode\": \"76\",\n" +
                "            \"showName\": \"巴西(BRAZIL)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"文莱\",\n" +
                "            \"dialingCode\": \"+673\",\n" +
                "            \"enName\": \"BRUNEI DARUSSALAM\",\n" +
                "            \"numberCode\": \"96\",\n" +
                "            \"showName\": \"文莱(BRUNEI DARUSSALAM)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"保加利亚\",\n" +
                "            \"dialingCode\": \"+359\",\n" +
                "            \"enName\": \"BULGARIA\",\n" +
                "            \"numberCode\": \"100\",\n" +
                "            \"showName\": \"保加利亚(BULGARIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"布基纳法索\",\n" +
                "            \"dialingCode\": \"+226\",\n" +
                "            \"enName\": \"BURKINA FASO\",\n" +
                "            \"numberCode\": \"854\",\n" +
                "            \"showName\": \"布基纳法索(BURKINA FASO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"布隆迪\",\n" +
                "            \"dialingCode\": \"+257\",\n" +
                "            \"enName\": \"BURUNDI\",\n" +
                "            \"numberCode\": \"108\",\n" +
                "            \"showName\": \"布隆迪(BURUNDI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"柬埔寨\",\n" +
                "            \"dialingCode\": \"+855\",\n" +
                "            \"enName\": \"CAMBODIA\",\n" +
                "            \"numberCode\": \"116\",\n" +
                "            \"showName\": \"柬埔寨(CAMBODIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"喀麦隆\",\n" +
                "            \"dialingCode\": \"+237\",\n" +
                "            \"enName\": \"CAMEROON\",\n" +
                "            \"numberCode\": \"120\",\n" +
                "            \"showName\": \"喀麦隆(CAMEROON)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"加拿大\",\n" +
                "            \"dialingCode\": \"+1\",\n" +
                "            \"enName\": \"CANADA\",\n" +
                "            \"numberCode\": \"124\",\n" +
                "            \"showName\": \"加拿大(CANADA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"开曼群岛\",\n" +
                "            \"dialingCode\": \"+1345\",\n" +
                "            \"enName\": \"CAYMAN ISLANDS\",\n" +
                "            \"numberCode\": \"136\",\n" +
                "            \"sho\n" +
                " wName\": \"开曼群岛(CAYMAN ISLANDS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"中非共和国\",\n" +
                "            \"dialingCode\": \"+236\",\n" +
                "            \"enName\": \"CENTRAL AFRICAN REPUBLIC\",\n" +
                "            \"numberCode\": \"140\",\n" +
                "            \"showName\": \"中非共和国(CENTRAL AFRICAN REPUBLIC)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乍得\",\n" +
                "            \"dialingCode\": \"+235\",\n" +
                "            \"enName\": \"CHAD\",\n" +
                "            \"numberCode\": \"148\",\n" +
                "            \"showName\": \"乍得(CHAD)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"智利\",\n" +
                "            \"dialingCode\": \"+56\",\n" +
                "            \"enName\": \"CHILE\",\n" +
                "            \"numberCode\": \"152\",\n" +
                "            \"showName\": \"智利(CHILE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"中国\",\n" +
                "            \"dialingCode\": \"+86\",\n" +
                "            \"enName\": \"CHINA\",\n" +
                "            \"numberCode\": \"156\",\n" +
                "            \"showName\": \"中国(CHINA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"哥伦比亚\",\n" +
                "            \"dialingCode\": \"+57\",\n" +
                "            \"enName\": \"COLOMBIA\",\n" +
                "            \"numberCode\": \"170\",\n" +
                "            \"showName\": \"哥伦比亚(COLOMBIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"刚果\",\n" +
                "            \"dialingCode\": \"+242\",\n" +
                "            \"enName\": \"CONGO\",\n" +
                "            \"numberCode\": \"178\",\n" +
                "            \"showName\": \"刚果(CONGO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"库克群岛\",\n" +
                "            \"dialingCode\": \"+682\",\n" +
                "            \"enName\": \"COOK ISLANDS\",\n" +
                "            \"numberCode\": \"184\",\n" +
                "            \"showName\": \"库克群岛(COOK ISLANDS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"哥斯达黎加\",\n" +
                "            \"dialingCode\": \"+506\",\n" +
                "            \"enName\": \"COSTA RICA\",\n" +
                "            \"numberCode\": \"188\",\n" +
                "            \"showName\": \"哥斯达黎加(COSTA RICA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"科特迪瓦\",\n" +
                "            \"dialingCode\": \"+225\",\n" +
                "            \"enName\": \"CÔTE D'IVOIRE\",\n" +
                "            \"numberCode\": \"384\",\n" +
                "            \"showName\": \"科特迪瓦(CÔTE D'IVOIRE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"古巴\",\n" +
                "            \"dialingCode\": \"+53\",\n" +
                "            \"enName\": \"CUBA\",\n" +
                "            \"numberCode\": \"192\",\n" +
                "            \"showName\": \"古巴(CUBA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"塞浦路斯\",\n" +
                "            \"dialingCode\": \"+357\",\n" +
                "            \"enName\": \"CYPRUS\",\n" +
                "            \"numberCode\": \"196\",\n" +
                "            \"showName\": \"塞浦路斯(CYPRUS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"捷克共和国\",\n" +
                "            \"dialingCode\": \"+420\",\n" +
                "            \"enName\": \"CZECH REPUBLIC\",\n" +
                "            \"numberCode\": \"203\",\n" +
                "            \"showName\": \"捷克共和国(CZECH REPUBLIC)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"丹麦\",\n" +
                "            \"dialingCode\": \"+45\",\n" +
                "            \"enName\": \"DENMARK\",\n" +
                "            \"numberCode\": \"208\",\n" +
                "            \"showName\": \"丹麦(DENMARK)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"吉布提\",\n" +
                "            \"dialingCode\": \"+253\",\n" +
                "            \"enName\": \"DJIBOUTI\",\n" +
                "            \"numberCode\": \"262\",\n" +
                "            \"showName\": \"吉布提(DJIBOUTI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"多米尼加共和国\",\n" +
                "            \"dialingCode\": \"+1890\",\n" +
                "            \"enName\": \"DOMINICAN REPUBLIC\",\n" +
                "            \"numberCode\": \"214\",\n" +
                "            \"showName\": \"多米尼加共和国(DOMINICAN REPUBLIC)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"厄瓜多尔\",\n" +
                "            \"dialingCode\": \"+593\",\n" +
                "            \"enName\": \"ECUADOR\",\n" +
                "            \"numberCode\": \"218\",\n" +
                "            \"showName\": \"厄瓜多尔(ECUADOR)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"埃及\",\n" +
                "            \"dialingCode\": \"+20\",\n" +
                "            \"enName\": \"EGYPT\",\n" +
                "            \"numberCode\": \"818\",\n" +
                "            \"showName\": \"埃及(EGYPT)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"萨尔瓦多\",\n" +
                "            \"dialingCode\": \"+503\",\n" +
                "            \"enName\": \"EL SALVADOR\",\n" +
                "            \"numberCode\": \"222\",\n" +
                "            \"showName\": \"萨尔瓦多(EL SALVADOR)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"爱沙尼亚\",\n" +
                "            \"dialingCode\": \"+372\",\n" +
                "            \"enName\": \"ESTONIA\",\n" +
                "            \"numberCode\": \"233\",\n" +
                "            \"showName\": \"爱沙尼亚(ESTONIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"埃塞俄比亚\",\n" +
                "            \"dialingCode\": \"+251\",\n" +
                "            \"enName\": \"ETHIOPIA\",\n" +
                "            \"numberCode\": \"231\",\n" +
                "            \"showName\": \"埃塞俄比亚(ETHIOPIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"斐济群岛\",\n" +
                "            \"dialingCode\": \"+679\",\n" +
                "            \"enName\": \"FIJI\",\n" +
                "            \"numberCode\": \"242\",\n" +
                "            \"showName\": \"斐济群岛(FIJI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"芬兰\",\n" +
                "            \"dialingCode\": \"+358\",\n" +
                "            \"enName\": \"FINLAND\",\n" +
                "            \"numberCode\": \"246\",\n" +
                "            \"showName\": \"芬兰(FINLAND)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"法国\",\n" +
                "            \"dialingCode\": \"+33\",\n" +
                "            \"enName\": \"FRANCE\",\n" +
                "            \"numberCode\": \"250\",\n" +
                "            \"showName\": \"法国(FRANCE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"法属圭亚那\",\n" +
                "            \"dialingCode\": \"+594\",\n" +
                "            \"enName\": \"FRENCH GUIANA\",\n" +
                "            \"numberCode\": \"254\",\n" +
                "            \"showName\": \"法属圭亚那(FRENCH GUIANA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"法属波利尼西亚\",\n" +
                "            \"dialingCode\": \"+689\",\n" +
                "            \"enName\": \"FRENCH POLYNESIA\",\n" +
                "            \"numberCode\": \"258\",\n" +
                "            \"showName\": \"法属波利尼西亚(FRENCH POLYNESIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"加蓬\",\n" +
                "            \"dialingCode\": \"+241\",\n" +
                "            \"enName\": \"GABON\",\n" +
                "            \"numberCode\": \"266\",\n" +
                "            \"showName\": \"加蓬(GABON)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"冈比亚\",\n" +
                "            \"dialingCode\": \"+220\",\n" +
                "            \"enName\": \"GAMBIA\",\n" +
                "            \"numberCode\": \"270\",\n" +
                "            \"showName\": \"冈比亚(GAMBIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乔治亚\",\n" +
                "            \"dialingCode\": \"+995\",\n" +
                "            \"enName\": \"GEORGIA\",\n" +
                "            \"numberCode\": \"268\",\n" +
                "            \"showName\": \"乔治亚(GEORGIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"德国\",\n" +
                "            \"dialingCode\": \"+49\",\n" +
                "            \"enName\": \"GERMANY\",\n" +
                "            \"numberCode\": \"276\",\n" +
                "            \"showName\": \"德国(GERMANY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"加纳\",\n" +
                "            \"dialingCode\": \"+233\",\n" +
                "            \"enName\": \"GHANA\",\n" +
                "            \"numberCode\": \"288\",\n" +
                "            \"showName\": \"加纳(GHANA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"直布罗陀\",\n" +
                "            \"dialingCode\": \"+350\",\n" +
                "            \"enName\": \"GIBRALTAR\",\n" +
                "            \"numberCode\": \"292\",\n" +
                "            \"showName\": \"直布罗陀(GIBRALTAR)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"希腊\",\n" +
                "            \"dialingCode\": \"+30\",\n" +
                "            \"enName\": \"GREECE\",\n" +
                "            \"numberCode\": \"300\",\n" +
                "            \"showName\": \"希腊(GREECE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"格林纳达\",\n" +
                "            \"dialingCode\": \"+1809\",\n" +
                "            \"enName\": \"GRENADA\",\n" +
                "            \"numberCode\": \"308\",\n" +
                "            \"showName\": \"格林纳达(GRENADA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"关岛\",\n" +
                "            \"dialingCode\": \"+1671\",\n" +
                "            \"enName\": \"GUAM\",\n" +
                "            \"numberCode\": \"316\",\n" +
                "            \"showName\": \"关岛(GUAM)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"危地马拉\",\n" +
                "            \"dialingCode\": \"+502\",\n" +
                "            \"enName\": \"GUATEMALA\",\n" +
                "            \"numberCode\": \"320\",\n" +
                "            \"showName\": \"危地马拉(GUATEMALA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"几内亚\",\n" +
                "            \"dialingCode\": \"+224\",\n" +
                "            \"enName\": \"GUINEA\",\n" +
                "            \"numberCode\": \"324\",\n" +
                "            \"showName\": \"几内亚(GUINEA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"圭亚那\",\n" +
                "            \"dialingCode\": \"+592\",\n" +
                "            \"enName\": \"GUYANA\",\n" +
                "            \"numberCode\": \"328\",\n" +
                "            \"showName\": \"圭亚那(GUYANA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"海地\",\n" +
                "            \"dialingCode\": \"+509\",\n" +
                "            \"enName\": \"HAITI\",\n" +
                "            \"numberCode\": \"332\",\n" +
                "            \"showName\": \"海地(HAITI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"洪都拉斯\",\n" +
                "            \"dialingCode\": \"+504\",\n" +
                "            \"enName\": \"HONDURAS\",\n" +
                "            \"numberCode\": \"340\",\n" +
                "            \"showName\": \"洪都拉斯(HONDURAS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"中国香港\",\n" +
                "            \"dialingCode\": \"+852\",\n" +
                "            \"enName\": \"HONG KONG\",\n" +
                "            \"numberCode\": \"344\",\n" +
                "            \"showName\": \"中国香港(HONG KONG)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"匈牙利\",\n" +
                "            \"dialingCode\": \"+36\",\n" +
                "            \"enName\": \"HUNGARY\",\n" +
                "            \"numberCode\": \"348\",\n" +
                "            \"showName\": \"匈牙利(HUNGARY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"冰岛\",\n" +
                "            \"dialingCode\": \"+354\",\n" +
                "            \"enName\": \"ICELAND\",\n" +
                "            \"numberCode\": \"352\",\n" +
                "            \"showName\": \"冰岛(ICELAND)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"印度\",\n" +
                "            \"dialingCode\": \"+91\",\n" +
                "            \"enName\": \"INDIA\",\n" +
                "            \"numberCode\": \"356\",\n" +
                "            \"showName\": \"印度(INDIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"印度尼西亚\",\n" +
                "            \"dialingCode\": \"+62\",\n" +
                "            \"enName\": \"INDONESIA\",\n" +
                "            \"numberCode\": \"360\",\n" +
                "            \"showName\": \"印度尼西亚(INDONESIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"伊朗\",\n" +
                "            \"dialingCode\": \"+98\",\n" +
                "            \"enName\": \"IRAN, ISLAMIC REPUBLIC OF\",\n" +
                "            \"numberCode\": \"364\",\n" +
                "            \"showName\": \"伊朗(IRAN, ISLAMIC REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"伊拉克\",\n" +
                "            \"dialingCode\": \"+964\",\n" +
                "            \"enName\": \"IRAQ\",\n" +
                "            \"numberCode\": \"368\",\n" +
                "            \"showName\": \"伊拉克(IRAQ)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"爱尔兰\",\n" +
                "            \"dialingCode\": \"+353\",\n" +
                "            \"enName\": \"IRELAND\",\n" +
                "            \"numberCode\": \"372\",\n" +
                "            \"showName\": \"爱尔兰(IRELAND)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"以色列\",\n" +
                "            \"dialingCode\": \"+972\",\n" +
                "            \"enName\": \"ISRAEL\",\n" +
                "            \"numberCode\": \"376\",\n" +
                "            \"showName\": \"以色列(ISRAEL)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"意大利\",\n" +
                "            \"dialingCode\": \"+39\",\n" +
                "            \"enName\": \"ITALY\",\n" +
                "            \"numberCode\": \"380\",\n" +
                "            \"showName\": \"意大利(ITALY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"牙买加\",\n" +
                "            \"dialingCode\": \"+1876\",\n" +
                "            \"enName\": \"JAMAICA\",\n" +
                "            \"numberCode\": \"388\",\n" +
                "            \"showName\": \"牙买加(JAMAICA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"日本\",\n" +
                "            \"dialingCode\": \"+81\",\n" +
                "            \"enName\": \"JAPAN\",\n" +
                "            \"numberCode\": \"392\",\n" +
                "            \"showName\": \"日本(JAPAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"约旦\",\n" +
                "            \"dialingCode\": \"+962\",\n" +
                "            \"enName\": \"JORDAN\",\n" +
                "            \"numberCode\": \"400\",\n" +
                "            \"showName\": \"约旦(JORDAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"哈萨克斯坦\",\n" +
                "            \"dialingCode\": \"+327\",\n" +
                "            \"enName\": \"KAZAKHSTAN\",\n" +
                "            \"numberCode\": \"398\",\n" +
                "            \"showName\": \"哈萨克斯坦(KAZAKHSTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"肯尼亚\",\n" +
                "            \"dialingCode\": \"+254\",\n" +
                "            \"enName\": \"KENYA\",\n" +
                "            \"numberCode\": \"404\",\n" +
                "            \"showName\": \"肯尼亚(KENYA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"朝鲜\",\n" +
                "            \"dialingCode\": \"+850\",\n" +
                "            \"enName\": \"KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF\",\n" +
                "            \"numberCode\": \"408\",\n" +
                "            \"showName\": \"朝鲜(KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"韩国\",\n" +
                "            \"dialingCode\": \"+82\",\n" +
                "            \"enName\": \"KOREA, REPUBLIC OF\",\n" +
                "            \"numberCode\": \"410\",\n" +
                "            \"showName\": \"韩国(KOREA, REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"科威特\",\n" +
                "            \"dialingCode\": \"+965\",\n" +
                "            \"enName\": \"KUWAIT\",\n" +
                "            \"numberCode\": \"414\",\n" +
                "            \"showName\": \"科威特(KUWAIT)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"吉尔吉斯斯坦\",\n" +
                "            \"dialingCode\": \"+331\",\n" +
                "            \"enName\": \"KYRGYZSTAN\",\n" +
                "            \"numberCode\": \"417\",\n" +
                "            \"showName\": \"吉尔吉斯斯坦(KYRGYZSTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"老挝\",\n" +
                "            \"dialingCode\": \"+856\",\n" +
                "            \"enName\": \"LAO PEOPLE'S DEMOCRATIC REPUBLIC\",\n" +
                "            \"numberCode\": \"418\",\n" +
                "            \"showName\": \"老挝(LAO PEOPLE'S DEMOCRATIC REPUBLIC)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"拉脱维亚\",\n" +
                "            \"dialingCode\": \"+371\",\n" +
                "            \"enName\": \"LATVIA\",\n" +
                "            \"numberCode\": \"428\",\n" +
                "            \"showName\": \"拉脱维亚(LATVIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"黎巴嫩\",\n" +
                "            \"dialingCode\": \"+961\",\n" +
                "            \"enName\": \"LEBANON\",\n" +
                "            \"numberCode\": \"422\",\n" +
                "            \"showName\": \"黎巴嫩(LEBANON)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"莱索托\",\n" +
                "            \"dialingCode\": \"+266\",\n" +
                "            \"enName\": \"LESOTHO\",\n" +
                "            \"numberCode\": \"426\",\n" +
                "            \"showName\": \"莱索托(LESOTHO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"利比里亚\",\n" +
                "            \"dialingCode\": \"+231\",\n" +
                "            \"enName\": \"LIBERIA\",\n" +
                "            \"numberCode\": \"430\",\n" +
                "            \"showName\": \"利比里亚(LIBERIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"利比亚\",\n" +
                "            \"dialingCode\": \"+218\",\n" +
                "            \"enName\": \"LIBYAN ARAB JAMAHIRIYA\",\n" +
                "            \"numberCode\": \"434\",\n" +
                "            \"showName\": \"利比亚(LIBYAN ARAB JAMAHIRIYA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"列支敦士登\",\n" +
                "            \"dialingCode\": \"+423\",\n" +
                "            \"enName\": \"LIECHTENSTEIN\",\n" +
                "            \"numberCode\": \"438\",\n" +
                "            \"showName\": \"列支敦士登(LIECHTENSTEIN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"立陶宛\",\n" +
                "            \"dialingCode\": \"+370\",\n" +
                "            \"enName\": \"LITHUANIA\",\n" +
                "            \"numberCode\": \"440\",\n" +
                "            \"showName\": \"立陶宛(LITHUANIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"卢森堡\",\n" +
                "            \"dialingCode\": \"+3\n" +
                " 52\",\n" +
                "            \"enName\": \"LUXEMBOURG\",\n" +
                "            \"numberCode\": \"442\",\n" +
                "            \"showName\": \"卢森堡(LUXEMBOURG)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"中国澳门\",\n" +
                "            \"dialingCode\": \"+853\",\n" +
                "            \"enName\": \"MACAO\",\n" +
                "            \"numberCode\": \"446\",\n" +
                "            \"showName\": \"中国澳门(MACAO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马达加斯加\",\n" +
                "            \"dialingCode\": \"+261\",\n" +
                "            \"enName\": \"MADAGASCAR\",\n" +
                "            \"numberCode\": \"450\",\n" +
                "            \"showName\": \"马达加斯加(MADAGASCAR)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马拉维\",\n" +
                "            \"dialingCode\": \"+265\",\n" +
                "            \"enName\": \"MALAWI\",\n" +
                "            \"numberCode\": \"454\",\n" +
                "            \"showName\": \"马拉维(MALAWI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马来西亚\",\n" +
                "            \"dialingCode\": \"+60\",\n" +
                "            \"enName\": \"MALAYSIA\",\n" +
                "            \"numberCode\": \"458\",\n" +
                "            \"showName\": \"马来西亚(MALAYSIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马尔代夫\",\n" +
                "            \"dialingCode\": \"+960\",\n" +
                "            \"enName\": \"MALDIVES\",\n" +
                "            \"numberCode\": \"462\",\n" +
                "            \"showName\": \"马尔代夫(MALDIVES)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马里\",\n" +
                "            \"dialingCode\": \"+223\",\n" +
                "            \"enName\": \"MALI\",\n" +
                "            \"numberCode\": \"466\",\n" +
                "            \"showName\": \"马里(MALI)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马耳他\",\n" +
                "            \"dialingCode\": \"+356\",\n" +
                "            \"enName\": \"MALTA\",\n" +
                "            \"numberCode\": \"470\",\n" +
                "            \"showName\": \"马耳他(MALTA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"马提尼克岛\",\n" +
                "            \"dialingCode\": \"+596\",\n" +
                "            \"enName\": \"MARTINIQUE\",\n" +
                "            \"numberCode\": \"474\",\n" +
                "            \"showName\": \"马提尼克岛(MARTINIQUE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"毛里求斯\",\n" +
                "            \"dialingCode\": \"+230\",\n" +
                "            \"enName\": \"MAURITIUS\",\n" +
                "            \"numberCode\": \"480\",\n" +
                "            \"showName\": \"毛里求斯(MAURITIUS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"墨西哥\",\n" +
                "            \"dialingCode\": \"+52\",\n" +
                "            \"enName\": \"MEXICO\",\n" +
                "            \"numberCode\": \"484\",\n" +
                "            \"showName\": \"墨西哥(MEXICO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"摩尔多瓦\",\n" +
                "            \"dialingCode\": \"+373\",\n" +
                "            \"enName\": \"MOLDOVA, REPUBLIC OF\",\n" +
                "            \"numberCode\": \"498\",\n" +
                "            \"showName\": \"摩尔多瓦(MOLDOVA, REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"摩纳哥\",\n" +
                "            \"dialingCode\": \"+377\",\n" +
                "            \"enName\": \"MONACO\",\n" +
                "            \"numberCode\": \"492\",\n" +
                "            \"showName\": \"摩纳哥(MONACO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"蒙古\",\n" +
                "            \"dialingCode\": \"+976\",\n" +
                "            \"enName\": \"MONGOLIA\",\n" +
                "            \"numberCode\": \"496\",\n" +
                "            \"showName\": \"蒙古(MONGOLIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"蒙特塞拉特\",\n" +
                "            \"dialingCode\": \"+1664\",\n" +
                "            \"enName\": \"MONTSERRAT\",\n" +
                "            \"numberCode\": \"500\",\n" +
                "            \"showName\": \"蒙特塞拉特(MONTSERRAT)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"摩洛哥\",\n" +
                "            \"dialingCode\": \"+212\",\n" +
                "            \"enName\": \"MOROCCO\",\n" +
                "            \"numberCode\": \"504\",\n" +
                "            \"showName\": \"摩洛哥(MOROCCO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"莫桑比克\",\n" +
                "            \"dialingCode\": \"+258\",\n" +
                "            \"enName\": \"MOZAMBIQUE\",\n" +
                "            \"numberCode\": \"508\",\n" +
                "            \"showName\": \"莫桑比克(MOZAMBIQUE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"缅甸\",\n" +
                "            \"dialingCode\": \"+95\",\n" +
                "            \"enName\": \"MYANMAR\",\n" +
                "            \"numberCode\": \"104\",\n" +
                "            \"showName\": \"缅甸(MYANMAR)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"纳米比亚\",\n" +
                "            \"dialingCode\": \"+264\",\n" +
                "            \"enName\": \"NAMIBIA\",\n" +
                "            \"numberCode\": \"516\",\n" +
                "            \"showName\": \"纳米比亚(NAMIBIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"瑙鲁\",\n" +
                "            \"dialingCode\": \"+674\",\n" +
                "            \"enName\": \"NAURU\",\n" +
                "            \"numberCode\": \"520\",\n" +
                "            \"showName\": \"瑙鲁(NAURU)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"尼泊尔\",\n" +
                "            \"dialingCode\": \"+977\",\n" +
                "            \"enName\": \"NEPAL\",\n" +
                "            \"numberCode\": \"524\",\n" +
                "            \"showName\": \"尼泊尔(NEPAL)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"荷兰\",\n" +
                "            \"dialingCode\": \"+31\",\n" +
                "            \"enName\": \"NETHERLANDS\",\n" +
                "            \"numberCode\": \"528\",\n" +
                "            \"showName\": \"荷兰(NETHERLANDS)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"荷属安的列斯群岛\",\n" +
                "            \"dialingCode\": \"+599\",\n" +
                "            \"enName\": \"NETHERLANDS ANTILLES\",\n" +
                "            \"numberCode\": \"530\",\n" +
                "            \"showName\": \"荷属安的列斯群岛(NETHERLANDS ANTILLES)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"新西兰\",\n" +
                "            \"dialingCode\": \"+64\",\n" +
                "            \"enName\": \"NEW ZEALAND\",\n" +
                "            \"numberCode\": \"554\",\n" +
                "            \"showName\": \"新西兰(NEW ZEALAND)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"尼加拉瓜\",\n" +
                "            \"dialingCode\": \"+505\",\n" +
                "            \"enName\": \"NICARAGUA\",\n" +
                "            \"numberCode\": \"558\",\n" +
                "            \"showName\": \"尼加拉瓜(NICARAGUA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"尼日尔\",\n" +
                "            \"dialingCode\": \"+227\",\n" +
                "            \"enName\": \"NIGER\",\n" +
                "            \"numberCode\": \"562\",\n" +
                "            \"showName\": \"尼日尔(NIGER)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"尼日利亚\",\n" +
                "            \"dialingCode\": \"+234\",\n" +
                "            \"enName\": \"NIGERIA\",\n" +
                "            \"numberCode\": \"566\",\n" +
                "            \"showName\": \"尼日利亚(NIGERIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"挪威\",\n" +
                "            \"dialingCode\": \"+47\",\n" +
                "            \"enName\": \"NORWAY\",\n" +
                "            \"numberCode\": \"578\",\n" +
                "            \"showName\": \"挪威(NORWAY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿曼\",\n" +
                "            \"dialingCode\": \"+968\",\n" +
                "            \"enName\": \"OMAN\",\n" +
                "            \"numberCode\": \"512\",\n" +
                "            \"showName\": \"阿曼(OMAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴基斯坦\",\n" +
                "            \"dialingCode\": \"+92\",\n" +
                "            \"enName\": \"PAKISTAN\",\n" +
                "            \"numberCode\": \"586\",\n" +
                "            \"showName\": \"巴基斯坦(PAKISTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴拿马\",\n" +
                "            \"dialingCode\": \"+507\",\n" +
                "            \"enName\": \"PANAMA\",\n" +
                "            \"numberCode\": \"591\",\n" +
                "            \"showName\": \"巴拿马(PANAMA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴布亚新几内亚\",\n" +
                "            \"dialingCode\": \"+675\",\n" +
                "            \"enName\": \"PAPUA NEW GUINEA\",\n" +
                "            \"numberCode\": \"598\",\n" +
                "            \"showName\": \"巴布亚新几内亚(PAPUA NEW GUINEA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"巴拉圭\",\n" +
                "            \"dialingCode\": \"+595\",\n" +
                "            \"enName\": \"PARAGUAY\",\n" +
                "            \"numberCode\": \"600\",\n" +
                "            \"showName\": \"巴拉圭(PARAGUAY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"秘鲁\",\n" +
                "            \"dialingCode\": \"+51\",\n" +
                "            \"enName\": \"PERU\",\n" +
                "            \"numberCode\": \"604\",\n" +
                "            \"showName\n" +
                "showName\": \"中国台湾(TAIWAN, PROVINCE OF CHINA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"塔吉克斯坦\",\n" +
                "            \"dialingCode\": \"+992\",\n" +
                "            \"enName\": \"TAJIKISTAN\",\n" +
                "            \"numberCode\": \"762\",\n" +
                "            \"showName\": \"塔吉克斯坦(TAJIKISTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"坦桑尼亚\",\n" +
                "            \"dialingCode\": \"+255\",\n" +
                "            \"enName\": \"TANZANIA, UNITED REPUBLIC OF\",\n" +
                "            \"numberCode\": \"834\",\n" +
                "            \"showName\": \"坦桑尼亚(TANZANIA, UNITED REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"泰国\",\n" +
                "            \"dialingCode\": \"+66\",\n" +
                "            \"enName\": \"THAILAND\",\n" +
                "            \"numberCode\": \"764\",\n" +
                "            \"showName\": \"泰国(THAILAND)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"多哥\",\n" +
                "            \"dialingCode\": \"+228\",\n" +
                "            \"enName\": \"TOGO\",\n" +
                "            \"numberCode\": \"768\",\n" +
                "            \"showName\": \"多哥(TOGO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"汤加\",\n" +
                "            \"dialingCode\": \"+676\",\n" +
                "            \"enName\": \"TONGA\",\n" +
                "            \"numberCode\": \"776\",\n" +
                "            \"showName\": \"汤加(TONGA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"特立尼达和多巴哥\",\n" +
                "            \"dialingCode\": \"+1809\",\n" +
                "            \"enName\": \"TRINIDAD AND TOBAGO\",\n" +
                "            \"numberCode\": \"780\",\n" +
                "            \"showName\": \"特立尼达和多巴哥(TRINIDAD AND TOBAGO)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"突尼斯\",\n" +
                "            \"dialingCode\": \"+216\",\n" +
                "            \"enName\": \"TUNISIA\",\n" +
                "            \"numberCode\": \"788\",\n" +
                "            \"showName\": \"突尼斯(TUNISIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"土耳其\",\n" +
                "            \"dialingCode\": \"+90\",\n" +
                "            \"enName\": \"TURKEY\",\n" +
                "            \"numberCode\": \"792\",\n" +
                "            \"showName\": \"土耳其(TURKEY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"土库曼斯坦\",\n" +
                "            \"dialingCode\": \"+993\",\n" +
                "            \"enName\": \"TURKMENISTAN\",\n" +
                "            \"numberCode\": \"795\",\n" +
                "            \"showName\": \"土库曼斯坦(TURKMENISTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乌干达\",\n" +
                "            \"dialingCode\": \"+256\",\n" +
                "            \"enName\": \"UGANDA\",\n" +
                "            \"numberCode\": \"800\",\n" +
                "            \"showName\": \"乌干达(UGANDA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乌克兰\",\n" +
                "            \"dialingCode\": \"+380\",\n" +
                "            \"enName\": \"UKRAINE\",\n" +
                "            \"numberCode\": \"804\",\n" +
                "            \"showName\": \"乌克兰(UKRAINE)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"阿拉伯联合酋长国\",\n" +
                "            \"dialingCode\": \"+971\",\n" +
                "            \"enName\": \"UNITED ARAB EMIRATES\",\n" +
                "            \"numberCode\": \"784\",\n" +
                "            \"showName\": \"阿拉伯联合酋长国(UNITED ARAB EMIRATES)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"英国\",\n" +
                "            \"dialingCode\": \"+44\",\n" +
                "            \"enName\": \"UNITED KINGDOM\",\n" +
                "            \"numberCode\": \"826\",\n" +
                "            \"showName\": \"英国(UNITED KINGDOM)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"美国\",\n" +
                "            \"dialingCode\": \"+1\",\n" +
                "            \"enName\": \"UNITED STATES\",\n" +
                "            \"numberCode\": \"840\",\n" +
                "            \"showName\": \"美国(UNITED STATES)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乌拉圭\",\n" +
                "            \"dialingCode\": \"+598\",\n" +
                "            \"enName\": \"URUGUAY\",\n" +
                "            \"numberCode\": \"858\",\n" +
                "            \"showName\": \"乌拉圭(URUGUAY)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"乌兹别克斯坦\",\n" +
                "            \"dialingCode\": \"+233\",\n" +
                "            \"enName\": \"UZBEKISTAN\",\n" +
                "            \"numberCode\": \"860\",\n" +
                "            \"showName\": \"乌兹别克斯坦(UZBEKISTAN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"委内瑞拉\",\n" +
                "            \"dialingCode\": \"+58\",\n" +
                "            \"enName\": \"VENEZUELA, BOLIVARIAN REPUBLIC OF\",\n" +
                "            \"numberCode\": \"862\",\n" +
                "            \"showName\": \"委内瑞拉(VENEZUELA, BOLIVARIAN REPUBLIC OF)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"越南\",\n" +
                "            \"dialingCode\": \"+84\",\n" +
                "            \"enName\": \"VIET NAM\",\n" +
                "            \"numberCode\": \"704\",\n" +
                "            \"showName\": \"越南(VIET NAM)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"也门\",\n" +
                "            \"dialingCode\": \"+967\",\n" +
                "            \"enName\": \"YEMEN\",\n" +
                "            \"numberCode\": \"887\",\n" +
                "            \"showName\": \"也门(YEMEN)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"赞比亚\",\n" +
                "            \"dialingCode\": \"+260\",\n" +
                "            \"enName\": \"ZAMBIA\",\n" +
                "            \"numberCode\": \"894\",\n" +
                "            \"showName\": \"赞比亚(ZAMBIA)\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cnName\": \"津巴布韦\",\n" +
                "            \"dialingCode\": \"+263\",\n" +
                "            \"enName\": \"ZIMBABWE\",\n" +
                "            \"numberCode\": \"716\",\n" +
                "            \"showName\": \"津巴布韦(ZIMBABWE)\"\n" +
                "        }\n",Country.class);
        initView();
        initListener();
    }

    protected void initView() {
        recyler.setLayoutManager(new GridLayoutManager(this, 3));
        recyler.addItemDecoration(new AZTitleDecoration(new AZTitleDecoration.TitleAttributes(this)));
        adapter = new SelectCountryAdapter(dateList);
        recyler.setAdapter(adapter);
    }

    protected void initListener() {
        barList.setOnLetterChangeListener(letter -> {
            int position = adapter.getSortLettersFirstPosition(letter);
            if (position != -1 && null != recyler.getLayoutManager()) {
                if (recyler.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager manager = (LinearLayoutManager) recyler.getLayoutManager();
                    manager.scrollToPositionWithOffset(position, 0);
                } else {
                    recyler.getLayoutManager().scrollToPosition(position);
                }
            }
        });
    }

    public static void starSelectCountryActivity(Context context) {
        Intent intent = new Intent(context, SelectCountryActivity.class);
        context.startActivity(intent);
    }

}
