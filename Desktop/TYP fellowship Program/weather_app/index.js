async function getWeatherObject(city){
    const res = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=7f2860c5a43476e51c585f356cea12ef`)
    var results = await res.json() ;
    console.log(results) ;

    let icon_img = results.weather[0].icon ;
    let maxTemp = (results.main.temp_max - 273.15).toFixed(1) ;
    let minTemp = (results.main.temp_min - 273.15).toFixed(1) ;
    let avgTemp = (results.main.temp - 273.15).toFixed(1) ;
    let windSpeed = results.wind.speed ;
    let weather = results.weather[0].main ;
    let weatherDisc = results.weather[0].description ;
    let cityName = results.name ;
    let countryName = results.sys.country  ;

    createWeatherCard(icon_img , maxTemp , minTemp , windSpeed , weather, cityName, countryName , weatherDisc , avgTemp) ;

    document.querySelector("#cityname").value = "" ;

}


function createWeatherCard(weatherIcon , maxTemp , minTemp , windSpeed , weather , cityName , countryName , weatherDisc , avgTemp) {
    body = `
    <div class="">
                    <img src = "http://openweathermap.org/img/wn/${weatherIcon}.png" alt="not found ">
                    <div id = "card-one">
                    
                    <div class = "card-left">
                        
                        <div class="max-temp"><p>Max Temp - ${maxTemp}C</p></div>
                        <div class="min-temp"><p>Min Temp - ${minTemp}C</p></div>
                        <div class="wind-speed"><p>Wind Pace - ${windSpeed}m/sec</p></div>
                    </div>
                        <div class = "card-right">
                        <div class="avg-temp"><p>Avg Temp - ${avgTemp}C</p></div>
                            <div class="weather"><p>Weather - ${weather}</p></div>
                        </div>
                        
                    </div>
                    <div id = "card-two">
                        <h2>City Details</h2>
                        <div class = "ctynam"><p>City Name - ${cityName}</p></div>
                        <div class = "cntrynam"><p>Country Name -${countryName} </p></div>
                        
                        <div class="weather"><p>Weather - ${weatherDisc}</p></div>
                    </div>
                </div>
                ` ;
    let weatherDiv = document.createElement("div") ;
    weatherDiv.className = "weather-card" ;
    weatherDiv.innerHTML = body ;
    document.querySelector("#weather-container").appendChild(weatherDiv) ;

}