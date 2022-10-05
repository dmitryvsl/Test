package euroapp.sdeaz.data.repo;

import euroapp.sdeaz.data.model.SportNewData;
import euroapp.sdeaz.domain.mapper.Mapper;
import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.domain.repo.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class FakeSportNewsRepo implements Repository<List<SportNew>> {

    Mapper<SportNewData, SportNew> toDomainMapper;

    @Inject
    public FakeSportNewsRepo(Mapper<SportNewData, SportNew> toDomainMapper) {
        this.toDomainMapper = toDomainMapper;

        fillList();
    }

    List<SportNewData> data = new ArrayList<SportNewData>();

    @Override
    public Single<List<SportNew>> getData() {
        return Single.create(emitter -> {
            //Imitate network loading
            Thread.sleep(1500L);

            emitter.onSuccess(mapToDomain(data));
        });
    }

    List<SportNew> mapToDomain(List<SportNewData> data) {
        List<SportNew> domainData = new ArrayList<>();
        for (SportNewData sportNewData : data) {
            domainData.add(toDomainMapper.map(sportNewData));
        }
        return domainData;
    }

    void fillList() {
        data.add(new SportNewData(
                "https://ichef.bbci.co.uk/news/976/cpsprodpb/5B89/production/_126933432_d272f81d3fd1abe8a74573219b5d08ae177ee27d.jpg.webp",
                "Sport for Health Conference kicks off at World Innovation Summit for Health",
                "On the cusp of the FIFA World Cup, Qatar 2022TM, partners at the World Innovation Summit for Health (WISH) in Qatar are hosting a Sport for Health Conference to highlight how football and other sport can boost physical activity and address serious global public health concerns. \n" +
                        "\n" +
                        "The Sport for Health Conference aims to strengthen global efforts to decrease noncommunicable diseases (NCDs) and promote positive mental health and well-being. NCDs and mental health conditions cause considerable suffering and are major burdens on health systems and communities globally, with one person under 70 years dying every two seconds from an NCD.\n" +
                        "\n" +
                        "“Sport, such as football, can make a major contribution to improving public health by engaging people in regular, safe and social physical activity in their local communities which is one of the key recommendations outlined in the WHO Global Action Plan on Physical Activity” said Dr Fiona Bull, Head of the Physical Activity Unit at WHO\n" +
                        "\n" +
                        "The three-day conference will feature global sport and health experts, scientists and policy-makers from the Commonwealth Secretariat, the International Olympic Committee (IOC) and the Organisation for Economic Co-operation and Development (OECD). Together, they will examine how the popularity of sport can be leveraged to benefit health and increase participation in sports, and how mega sports events can leave more sustainable legacies which strengthen community participation in physical activity into the future.\n" +
                        "\n" +
                        "Regular physical activity and sports helps prevent and treat NCDs, and can also improve mental health and well-being. NCDs kill 41 million people each year, equivalent to 74% of all deaths globally. Physical inactivity increases the risk of dying from an NCD. Today, one in four adults and four in five adolescents globally are not active enough and there has been little change in the average levels of physical activity over the last 15 years.\n" +
                        "\n" +
                        "“Qatar, like so many countries around the world, has seen a rise in noncommunicable diseases such as obesity, diabetes, and heart disease in recent decades,” said Sheikh Dr Mohamed Bin Hamad Al-Thani, Director of Public Health Department at the Ministry of Public Health, Qatar.\n" +
                        "\n" +
                        "“In Qatar, we understand the role that sport, physical activity and healthy lifestyles can have in halting this trend and our National Health Strategy and Public Health Strategy both place great priority on promoting the benefits of physical and healthy lifestyles to our population as a key approach to combatting noncommunicable diseases.” \n" +
                        "\n" +
                        "Keynote speakers at the Sport for Health conference include: Nasser A. Al-Khori, Executive Director, Generation Amazing Foundation, who will share preparation and plans for the FIFA World Cup Qatar 2022TM legacy;  Peter Krustrup (Denmark) who initiated the “Football is Medicine” research consortia  of more than 200 researchers from 26 countries; and Matthew Philpott (UK), Executive Director, European Healthy Stadia Network CIC, who will share insights into how sports stadia venues can contribute to improving public health and raising levels of physical activity among populations.\n" +
                        "\n" +
                        "“We are very happy to partner with the Ministry of Public Health and WHO to shed light on the importance of sport and the ways it can positively impact the health of individuals and communities,” said Mr Al Khori. \"Over the years, GA has developed programmes and tailored curricula to address a variety of social issues that impact youth and their well-being. We are excited to announce our latest module at the conference, which focuses on mental health and aims to provide sport for development practitioners with the knowledge and tools necessary to help cultivate self-awareness and influence positive behavioural change.”\n" +
                        "\n" +
                        "The Football is Medicine 4th Annual Meeting which is into the Sport for Health Conference, will examine the scientific evidence of the benefits of football for healthy ageing, prevention and management of noncommunicable diseases, and positive mental health. Two practical football workshops will showcase how to offer safe, effective and enjoyable ways to be more active and improve mental and physical health of NCD patients and children of all abilities.\n" +
                        "\n" +
                        "“Football is a strong and important tool for global health promotion. It is versatile, effective, fun and social, and it’s a global language,” said Mr Krustrup. “Football training is optimal for broad-spectrum prevention and treatment of noncommunicable diseases. “\n" +
                        "\n" +
                        "The Sport for Health Conference, and the 4th Annual Meeting of Football is Medicine (FIM), is co-hosted by the World Health Organization, the Qatar Ministry of Public Health and Generation Amazing Foundation. It is an activity undertaken as part of the Healthy FIFA World Cup Qatar 2022™ – Creating Legacy for Sport and Health Initiative, a partnership between WHO, FIFA, State of Qatar (Ministry of Public Health) and Qatar’s Supreme Committee for Delivery & Legacy.",
                "5 min",
                2509)
        );
        data.add(new SportNewData(
                "https://www.sc.edu/uofsc/images/story_images/2022/10-story-hrsm-football-alex-hill.jpg",
                "Business of Football",
                "Inside the classroom, students are learning in specialized courses like gameday operations, sport marketing and venue management from a combination of faculty who are world-class researchers and who have served as team presidents and athletic directors. Outside the classroom students are learning by doing – helping to run SEC college football games, bowl games, the College Football Playoff and the biggest of all U.S. sporting events, the Super Bowl. And with every undergraduate student required to complete two internships, lessons are quickly put into practice.\n" +
                        "\n" +
                        "“What put me at an advantage over other candidates in my hiring class out of college was the experience I was fortunate enough to gain through the internship requirements of the sport and entertainment management program,” says alumna Maddie Ballengee, who now works as assistant merchandise director with Legends Hospitality at AT&T Stadium (home of the Dallas Cowboys). “Our field is very hands on and having experience under two major sports organizations before I even graduated put me ten steps ahead when transitioning into my career in the sports industry. I also appreciated the fact that many of my professors built our course work around very relevant, industry related events and scenarios.”\n" +
                        "\n" +
                        "The Department of Sport and Entertainment Management’s faculty members are leaders in sport research, with specialized centers and scholars dedicated to college sport, ticketing, sport law, fan experience, sport gambling, economic impact, sustainable business operations and more. While the research spans the spectrum of sports and entertainment, football is often the focal point. For example, Associate Professor Tom Regan has conducted more than 80 economic impact studies for organizations including the Denver Broncos and Carolina Panthers, as well as Gamecocks football.\n" +
                        "\n" +
                        "Group of UofSC alumni standing on the football field with professor Danny Morrison.\n" +
                        "Danny Morrison, 4th from the right, teaches master's level courses on sport management at UofSC and gives students and alumni the opportunity to gain experience with Charlotte Sports Foundation where he serves as executive director.\n" +
                        "Having faculty leading the way in research shapes the lessons in the classrooms. Professors infuse the curriculum with the latest findings as well as integrating current events happening in real time. If a topic related to the business side of football is in the news, it is also being discussed and debated on campus in Columbia, often by industry leaders. \n" +
                        "\n" +
                        "The Department of Sport and Entertainment Management’s reputation for education excellence has attracted a roster of uniquely experienced faculty and industry partners. Former Carolina Panthers President and current Charlotte Sports Foundation Executive Director Danny Morrison joined the faculty in 2017.\n" +
                        "\n" +
                        "“It was an easy decision to choose South Carolina,” says Morrison, who is now a professor of practice teaching master’s level sport management courses. “I was always impressed by the caliber of students from the program who came to work for the Panthers, and the faculty and quality of work they are doing is excellent.”\n" +
                        "\n" +
                        "The program’s reputation also contributed to the decision by David and Nicole Tepper, owners of the Panthers, to create the Tepper Scholars program at South Carolina in 2020. The prestigious scholarship and career development program is designed to attract the best and brightest sport and entertainment management students with an emphasis on supporting underrepresented students. \n" +
                        "\n" +
                        "Increasing diversity and inclusion in the field of sport management has been a focus for the program. In addition to several specialized scholarships, student clubs and mentorship opportunities for underrepresented students, it is continually opening doors for anyone willing to work hard to earn a career in football, including those for whom the doors were once closed. \n" +
                        "\n" +
                        "“How many Asians do you see in football? I didn’t have anyone who looked like me in the NFL growing up, so I hope that one day, there’s a little Asian girl or boy who sees me and says, ‘I want to be like KJ, she’s my role model,’” says 2020 sport and entertainment management master’s program alumna Kjahna O, now scouting coordinator for the Atlanta Falcons.",
                "13 min",
                6598)
        );
        data.add(new SportNewData(
                "https://e3.365dm.com/22/10/1600x900/skynews-sports-contraversies_5919833.jpg?20221004125851",
                "First chess, now fishing and poker – famous cheating scandals that have rocked sport",
                "In recent weeks the world of chess, fishing and poker have been rattled by cheating scandals.\n" +
                        "\n" +
                        "From weights inserted into fish to make them heavier - to a world champion sensationally pulling out of a tournament after a single move, cheating allegations are always quick to make headlines.\n" +
                        "\n" +
                        "Sponsored link\n" +
                        "Recommended byWhat is Outbrain\n" +
                        "Wall St. Legend Warns: \"A Big Change Is Coming\"\n" +
                        "Wall St. Legend Warns: \"A Big Change Is Coming\"\n" +
                        "Visionary Profit\n" +
                        "Hier sind die 23+ angesagtesten Geschenke für 2022!\n" +
                        "IM TREND\n" +
                        "Here Sky News looks at how sports stars have tried - and failed - to break the rules over the years.\n" +
                        "\n" +
                        "Poker\n" +
                        "\n" +
                        "hustlers casino  in los angeles\n" +
                        "Last week a high-stakes poker game was stopped at Hustler Casino in Los Angeles.\n" +
                        "\n" +
                        "It happened after player Robbi Jade Lew called her opponent Garrett Adelstein's bluff - despite having an underwhelming hand.\n" +
                        "\n" +
                        "It would have won her $269,000 (£241,000), but after an icy stare from her opponent and claims he \"threatened her\" over such an unbelievable move, she returned the chips she was due to win.",
                "6 min",
                2758)
        );
        data.add(new SportNewData(
                "https://e0.365dm.com/22/07/1600x900/skysports-england-women-euros_5851249.jpg?20220731200822",
                "Women's Euros: Record-breaking 365m people watched tournament",
                "A record-breaking 365m people around the globe watched the Women's Euros in the summer as England lifted the trophy.\n" +
                        "\n" +
                        "UEFA, European football's governing body, released a report on Tuesday by Ernst and Young revealing the positive impact of the tournament which was held in England.\n" +
                        "There was an average match attendance of 18,544 across all games, with a total of 574,875 spectators across all fixtures and 85 per cent of those likely to go to women's football matches again in the future.\n" +
                        "Eighty-four per cent of spectators said their experience watching the tournament has improved their perception of women's football with 88 per cent likely to watch a women's game on TV.\n" +
                        "The value of television rights soared by 289 per cent compared to the previous tournament, which boosts the finances of professional women's teams.\n" +
                        "\n" +
                        "At a grassroots level, more than 416,000 opportunities were created in England across schools, clubs, and the community to engage women and girls in grassroots legacy football activities across the host cities.",
                "8 min",
                284)
        );
        data.add(new SportNewData(
                "https://assets.publishing.service.gov.uk/government/uploads/system/uploads/image_data/file/163740/s300_CWG_swimmer_gov.uk.jpg",
                "£60 million fund to boost investment and access to sport and culture in the West Midlands",
                "The UK government will invest around £60 million of underspend from the Birmingham 2022 budget in the West Midlands to enhance the legacy of the brilliant Commonwealth Games hosted earlier this year. The fund will aim to increase access to sport and culture, boost the West Midlands’s reputation as a world-class host for major events and drive inward investment and tourism.\n" +
                        "\n" +
                        "The Department for Digital, Culture, Media and Sport (DCMS) will work with the West Midlands Combined Authority and Birmingham City Council to capitalise on the success of the Games and help more people engage with sport and culture in the region.\n" +
                        "\n" +
                        "The funding will also be allocated to boost inward business investment and tourism and help drive further economic growth in the West Midlands.\n" +
                        "\n" +
                        "The Commonwealth Games was backed by £778 million of public funding, providing the West Midlands with a refurbished athletics stadium in Perry Barr and a brand-new aquatics centre in Smethwick. Alongside these world-class venues, the £60 million investment will support the region’s ambition to host future major events.\n" +
                        "\n" +
                        "This investment builds on existing legacy programmes already being rolled out. In partnership with DCMS, Sport England will continue to boost access to sport through a Birmingham 2022 kit giveaway. 16,000 items from basketballs to bibs will be gifted to West Midlands community groups in the coming months.\n" +
                        "\n" +
                        "Birmingham 2022 was the fairest, greenest and fastest Commonwealth Games ever, delivered in four and a half years, rather than the seven that normally happens for a Games, and committed to a carbon neutral legacy. As well as having the biggest ever para-sport programme, the Games also awarded women with more medals than men. Birmingham 2022’s 11 days of sport was complemented by a 6-month cultural festival and the first ever Games-accredited business and tourism programme.\n" +
                        "\n" +
                        "Birmingham 2022 was the best-selling Commonwealth Games to be held in the UK with over 1.5 million tickets sold, and the most watched Games on the BBC’s digital platforms with 57.1 million streams.",
                "4 min",
                568)
        );
        data.add(new SportNewData(
                "https://library.sportingnews.com/styles/crop_style_16_9_desktop/s3/2022-09/Allen-Lazard-091922-getty-ftr.jpg?h=920929c4&itok=UFmZr9w_",
                "NFL power rankings: Undefeated Eagles soar to No. 1; Chiefs, Cowboys also rise as Broncos, Steelers fade for Week 5",
                "The NFL has only one undefeated team left after the first month of the 222 season. Congratulations to the Eagles for getting through almost a quarter of the schedule at 4-0. Their reward is ascending to the top of the latest Sporting News power rankings.\n" +
                        "\n" +
                        "Philadelphia has emerged as one of the teams to beat in NFC on the road to Super Bowl 57. A returning playoff team from 2021, the Eagles are right up there with the Packers, Buccaneers, Rams and 49ers on the short list of conference title contenders. But the Eagles still have only a one-game lead in the East over the reigning division champion Cowboys.\n" +
                        "\n" +
                        "Here's looking at Philadelphia's ascension to the top spot and how every team follows, from No. 2 through No. 32 going into Week 5:" +
                        "\n" +
                        "1. Philadelphia Eagles 4-0 (previous ranking: 3)\n" +
                        "\n" +
                        "The Eagles went down into a 14-0 hole against the Jaguars at home but casually erased with sticking with the run in bad weather and Jalen Hurts being in full command of their offense. The defense also was up to cooling off a hot young QB.\n" +
                        "\n" +
                        "2. Buffalo Bills 3-1 (2)\n" +
                        "\n" +
                        "The Bills took a while to get their passing game going in rainy Baltimore before Josh Allen decided to take over with his arm and legs, pushing himself back into the MVP lead. The shorthanded pass defense also overachieved again.",
                "11 min",
                6976)
        );
        data.add(new SportNewData(
                "https://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/1508/2022/06/06160150/sports.jpg",
                "Oklahoma sports ‘biological sex affidavit’ raises questions",
                "OKLAHOMA CITY (AP) — J.D. Runnels and his son, James, share a love for football.\n" +
                        "\n" +
                        "Runnels played for the University of Oklahoma and in the National Football League, and he coached in the United States Football League this past season. His son plays center for Southridge Middle School’s eighth-grade team in Moore, an Oklahoma City suburb.\n" +
                        "\n" +
                        "James nearly was held out of playing this season because his parents objected to the “biological sex affidavit” Oklahoma public school athletes, from kindergarten to college, are now required to submit to participate. The form — part of a law its author says is aimed at ensuring girls’ and women’s teams allow only cisgender females — asks what sex a student was at birth.\n" +
                        "\n" +
                        "J.D. said James’ mother considered it government overreach and “none of their business.” They considered not turning in the form for their son, who is cisgender.\n" +
                        "\n" +
                        "Runnels convinced her that their son should play, but he understands her passion about the issue. Runnels said he learned the intricacies of gender identity when he taught and coached at Moore West (Oklahoma) Middle School.",
                "9 min",
                197)
        );
        data.add(new SportNewData(
                "https://i0.wp.com/news.northeastern.edu/wp-content/uploads/2022/09/Federer1400.jpg?fit=1400%2C933&ssl=1",
                "ICONIC ROGER FEDERER PHOTOGRAPH HAS MANY TALKING ABOUT HOW ‘MASCULINITY AND MANHOOD’ ARE PORTRAYED IN SPORT",
                "The iconography of men’s sport turns on displays of triumph and dominance. \n" +
                        "\n" +
                        "Tiger Woods fist pumping after sinking a birdie putt. Muhammad Ali standing menacingly over a fallen George Foreman. Michael Jordan, tongue out, defying gravity as he scales air and bodies to dunk the basketball—an image that, years later, would become the source of the “Jumpman” logo.\n" +
                        "\n" +
                        "Now, you can add another timeless sporting moment to that list—but one that stands in stark contrast to the rest.\n" +
                        "\n" +
                        "Instead of depictions of athleticism and feats of sporting conquest in the usual victory-pose-over-fallen-opponent frame, here’s a new tilt: 20-time Grand Slam champion and tennis icon Roger Federer, a transcendent force in men’s tennis and a fixture on television screens and the ATP Tour for decades, weeping and holding hands with his long-time rival Rafael Nadal, also in bits following the pair’s doubles loss at the Laver Cup in London. \n" +
                        "\n" +
                        "Headshot of Dan Lebowitz\n" +
                        "Dan Lebowitz, executive director of the Center for the Study of Sport in Society. Photo by Alyssa Stone/Northeastern University\n" +
                        "The image, captured by a freelance photographer on the evening of Federer’s final professional match on Sept. 23, circulated widely on social media. Users, journalists and sporting commentators were quick to embrace the photo—not least because it signaled an end of an era; but also because hand-holding among elite male athletes—particularly among two of the game’s GOATs (greatest of all time), who for years contested finals against each and “fought” to stay atop the tennis rankings—is an unusual sight.  \n" +
                        "\n" +
                        "However unusual, the photo sparked the imagination of a broad category of the public, starved of very public examples of notable men expressing affection and friendship in ways that challenge prevailing norms around masculine behavior, and the way boys are socialized into sport, Northeastern sporting observers say.  \n" +
                        "\n" +
                        "The photograph’s power lies not just in its portrayal of male emotion—athletes are often coached to be stoic and told to “keep their emotions in check”—but in the way that it confronts “hypermasculine” constructs in sport, says Daniel Lebowitz, executive director of the Center for the Study of Sport in Society at Northeastern.\n" +
                        "\n" +
                        "“It really hits at the intersection of affection and emotion,” he says.",
                "2 min",
                3975)
        );
        data.add(new SportNewData(
                "https://sm.imgix.net/22/37/livajax.jpg?",
                "Liverpool vs. Rangers - prediction, team news, lineups",
                "With their 2-1 win against Ajax last month representing Liverpool's only win in their last four matches in all competitions, Jurgen Klopp may be relieved to have a European fixture on the horizon when Rangers visit Merseyside in midweek.\n" +
                        "\n" +
                        "Klopp's side showed great character to turn a 2-0 deficit on its head by leading Brighton & Hove Albion 3-2 at Anfield on Saturday, but the Reds could not hold onto a vital victory as Leandro Trossard sealed his hat-trick late on in the game.\n" +
                        "\n" +
                        "The draw leaves Liverpool with only two wins from seven league games so far this season, but they will hope to make up ground on Napoli in Group A by beating Rangers on Tuesday.\n" +
                        "\n" +
                        "With Napoli and Ajax facing each other back-to-back in the next two matchdays, Klopp will be targeting six points from their two matches against the Scottish Premiership and Europa League runners-up, who undoubtedly represent the weakest team in the group.\n" +
                        "\n" +
                        "However, a team winning football matches as infrequently as Liverpool of late cannot afford any complacency to set in ahead of Tuesday's fixture, even if they may not require their very best performance levels to claim a win.\n" +
                        "That said, Rangers were ruthless in dispatching Hearts 4-0 away from home at the weekend, with Cameron Devlin's straight red card after 39 minutes leaving the hosts in a spot of bother considering Antonio Colak had already bagged a brace.\n" +
                        "\n" +
                        "Alfredo Morelos and former Liverpool winger Ryan Kent wrapped up the victory after the break, but Giovanni van Bronckhorst's attentions will quickly return to Europe, where his side have failed to impress so far this campaign following a glorious run to the Europa League final last season.\n" +
                        "\n" +
                        "It is Rangers' first foray into the Champions League group stage in 12 years, though, and perhaps the step up in quality of opposition has been a shock to everyone connected to the club, especially having been placed within what many dubbed the 'Group of Death' after August's draw.\n" +
                        "\n" +
                        "The Gers were thrashed 4-0 away to Ajax in their first game before losing 3-0 to Napoli at Ibrox Stadium last time out, with James Sands's 55th-minute sending off for a bookable offence always making the Italians favourites to find a winner from that point onwards.\n" +
                        "\n" +
                        "A trip to Anfield is not ideal for a team yet to claim their first point in the competition, but their out of sorts opponents could struggle to deal with van Bronckhorst's side's intensity, providing that they are at their usual standards in that regard.",
                "5 min",
                3975)
        );
        data.add(new SportNewData(
                "https://s3.amazonaws.com/socast-superdesk/media/20221003191028/633b380b023d1607f8ebfe6ajpeg.jpg",
                "Hockey Canada lacks transparency, needs new leadership: sport minister",
                "OTTAWA — Sport Minister Pascale St-Onge is once again calling for change in Hockey Canada’s leadership in the wake of new allegations against the troubled sporting body. \n" +
                        "\n" +
                        "The Globe and Mail reported Monday that Hockey Canada put player registration fees toward a second fund used to cover sexual assault claims and other lawsuits. The news follows revelations about another fund, known as the National Equity Fund.\n" +
                        "\n" +
                        "Speaking to reporters on Parliament Hill, St-Onge said the latest news shows a lack of transparency and that the organization has treated sexual violence as an “insurance problem.” \n" +
                        "\n" +
                        "It was revealed in the July hearings that Hockey Canada had paid out $7.6 million in nine settlements related to sexual assault and sexual abuse claims since 1989.",
                "4 min",
                988)
        );
        data.add(new SportNewData(
                "https://s3.amazonaws.com/socast-superdesk/media/20221003191028/633b380b023d1607f8ebfe6ajpeg.jpg",
                "EXPLAINER: Favre, other sports figures in welfare fraud case",
                "Mississippi’s largest public corruption case, in which tens of millions of dollars earmarked for needy families was misspent, involves a number of sports figures with ties to the state — including NFL royalty Brett Favre and a famous former pro wrestler.\n" +
                        "\n" +
                        "At the center, though, is the former head of the state’s Department of Human Services, John Davis, who pleaded guilty on Sept. 22 to federal counts of conspiracy and theft and state counts of conspiracy and fraud against the government. Davis has agreed to testify against others in the case. Other people who have pleaded guilty to state charges include a mother and son who ran a nonprofit and an education company.\n" +
                        "\n" +
                        "Here are the sports figures named in a civil lawsuit, which was filed on May 9, as well as the details from that suit, their responses if available and whether they’ve been charged.\n" +
                        "\n" +
                        "BRETT FAVRE\n" +
                        "\n" +
                        "The Hall of Famer, legendary Green Bay Packers quarterback, 1997 Super Bowl winner and University of Southern Mississippi alumnus is one of the celebrity centerpieces of the scandal — though Favre is not facing criminal charges." +
                        "Favre didn’t make appearances and later repaid the money, though $228,000 in interest is still outstanding.\n" +
                        "\n" +
                        "Texts messages made public in court documents also show that in July 2019, Favre texted with then-Mississippi Gov. Phil Bryant to ask if welfare money could be put toward building an indoor practice facility for the football team at the same school. That never went anywhere, with Bryant texting Favre in September that “we have to follow the law.”\n" +
                        "\n" +
                        "Favre also is named in the lawsuit as the “largest individual outside investor” of biotech firm Prevacus (now called Odyssey Health) and suggested that the CEO ask about using Human Services grant money for investing in company stock. It turned into $2.1 million of state money for Prevacus and “corporate affiliate” PreSolMD.",
                "10 min",
                101)
        );
        data.add(new SportNewData(
                "https://static01.nyt.com/images/2022/10/03/sports/03USSOCCER-REPORT/merlin_195910602_15eee6dc-462e-4ba0-8f71-e887503a905a-superJumbo.jpg?quality=75&auto=webp",
                "Report Details ‘Systemic’ Abuse of Players in Women’s Soccer",
                "One coach called in a player to review game film and showed her pornography instead. Another was notorious at the highest levels of women’s soccer for alternately berating his players and then quizzing them about their sex lives.\n" +
                        "\n" +
                        "A third coach coerced multiple players into sexual relationships, behavior that one top team found so disturbing that it fired him. But when he was hired by a rival team only a few months later, the original club, which had documented his behavior in an internal investigation, said nothing. Instead, it publicly wished him well in his new post.\n" +
                        "\n" +
                        "Those details and others fill a highly anticipated investigative report into abuse in women’s soccer that found sexual misconduct, verbal abuse and emotional abuse by coaches in the game’s top tier, the National Women’s Soccer League, and issued warnings that girls face abuse in youth soccer as well.\n" +
                        "\n" +
                        "The report was published Monday, a year after players outraged by what they saw as a culture of abuse in their sport demanded changes by refusing to take the field. It found that leaders of the N.W.S.L. and the United States Soccer Federation — the governing body of the sport in America — as well as owners, executives and coaches at all levels failed to act on years of voluminous and persistent reports of abuse by coaches.\n" +
                        "\n" +
                        "All were more concerned about being sued by coaches or about the teetering finances of women’s professional soccer than player welfare, according to the report, creating a system in which abusive and predatory coaches were able to move freely from team to team at the top levels of women’s soccer.\n" +
                        "\n" +
                        "“Our investigation has revealed a league in which abuse and misconduct — verbal and emotional abuse and sexual misconduct — had become systemic, spanning multiple teams, coaches and victims,” Sally Q. Yates, the lead investigator, wrote in the report’s executive summary. “Abuse in the N.W.S.L. is rooted in a deeper culture in women’s soccer, beginning in youth leagues, that normalizes verbally abusive coaching and blurs boundaries between coaches and players.”",
                "7 min",
                8738)
        );
    }

}
