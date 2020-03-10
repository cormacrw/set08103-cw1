# set08103-cw1
First coursework for Software Engineering Methods
[![Build Status](https://travis-ci.org/cormacrw/set08103-cw1.svg?branch=master)](https://travis-ci.org/cormacrw/set08103-cw1)

# Overview
We will be building the reports and serving them through a website. We will use Trello as a tool to keep track of what tasks each of us are working on.

# User Stories
- As a user I need to be able to gather data from the database
- As a user I need to be able to get the top countries ordered by population
- As a user I need to be able to get the top continents ordered by population
- As a user I need to be able to get the top capitals ordered by population
- As a user I need to be able to get the top cities ordered by population
- As a user I need to be able to limit the results by the amount I see fit
- As a user I need to be able to get the percentage of population

# Use cases


# group 19 members 
- Cormac Williamson
- Jack McKenna  
- Andrei Chirovici
- Christopher Scobie


# Code of conduct 
## Team work 
We are a group of four when creating and developing this project. Because of this it means that the work will be devided up and shared between group members equally to ensure the most efficient work and to make it collaberative. As well as this we will have bi weekly team meetings where we ensure that we are all still working towards to same goal as a group.
## Security 
Through out the project when handling sensitive or personal data we will follow all the set rquirements and laws that  are in place to preotect such data. This will endure the data security of all elements of this project 
## Behaviour 
During the project we will all be working closley together and all be bringing deifferent opions and developmkent plans to the table. To ensure that this is doesnt become a disruptive feature for our project behaviour will be set at a professional level where everyone is heard and contrasting opinions are voted for with the majority being the method used.
## Deadlines
Throughout this project there are many seperate deadlines for the group to meet. Beacuse of this we will use our bi weekly methods to maintain the work structure to ensure these deadlines are met punctually. 

# work layout submision 1 
https://docs.google.com/spreadsheets/d/1L7NcdjRmdt6YxblBG4ude9jL8dxua6V7huGiK5KsBVQ/edit#gid=0  


# Web Server routes

page | route
-----|-------
Home | /
All countries in world | /report/country/world
All countries in continent | /report/country/continent
All countries in region | /report/country/region
top x countries in world form | /form/country/world/top
top x countries in world report | /form/country/world/top/x

# Population query

By Country
```
select country.Name, country.Population, ROUND(SUM(city.Population) / country.Population * 100,1) as popInCity, ROUND((country.Population - SUM(city.Population)) / country.Population * 100, 1) as popOutCity from country join city on country.Code = city.CountryCode GROUP BY country.Code;
```

By Region
```
select Region, Name, cityPopulation, regionPopulation, round((cityPopulation/regionPopulation)*100,2) as popInCity, round(((regionPopulation-cityPopulation)/regionPopulation)*100,2) as popOutCity from ( select Region, name, population as cityPopulation, (select sum(co2.Population) from country co2 where co2.code = CountryCode) as regionPopulation from ( select co.Region, ci.name, ci.CountryCode, ci.Population from city ci left join country co on ci.CountryCode = co.Code group by co.Region,ci.Name, ci.CountryCode, ci.Population) as subqry ) as subqry2 order by Region,Name;
```