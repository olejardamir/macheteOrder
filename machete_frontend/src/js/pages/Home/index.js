import React from 'react';
import axios from 'axios';


export default class filmList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            films: [],
            isToggleOn: true,
            selectedOption: "tt0076759"
        }
        // This binding is necessary to make `this` work in the callback
        this.toggleFilms = this.toggleFilms.bind(this);
    }

    handleOptionChange = changeEvent => {
        this.setState({
            selectedOption: changeEvent.target.value
        });
    };

    handleFormSubmit = formSubmitEvent => {
        formSubmitEvent.preventDefault();

        const postdata = this.getFavouritePayload();


        axios.post('http://localhost:9095/saveFilm',
            postdata, {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            })
            .then(function(response) {
                console.log(response);
            })
            .catch(function(error) {
                console.log(error);
            });

        console.log("You have submitted:", this.state.selectedOption);
    };


    getFavouritePayload() {
        var ip = require('ip');
        const postdata = '{' +
            '"imdb_id":"' + this.state.selectedOption + '",' +
            '"ip":"' + ip.address() + '"' +
            '}';
        return postdata;
    }

    toggleFilms() {
        const postdata = this.getQueryJson();

        function collectData() {

            axios.post('http://localhost:9095/recordUser',
                postdata, {
                    headers: {
                        'content-type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(function(response) {
                    console.log(response);
                })
                .catch(function(error) {
                    console.log(error);
                });
        }

        collectData();
        if (this.state.isToggleOn) {
            this.setState(prevState => ({
                isToggleOn: !prevState.isToggleOn
            }));
            axios.get("http://localhost:9095/getMacheteOrder")
                .then(res => {
                    const films = res.data;
                    this.setState({
                        films
                    });
                });
        } else {
            this.setState(prevState => ({
                isToggleOn: !prevState.isToggleOn
            }));
            axios.get("http://localhost:9095/getFilmOrder")
                .then(res => {
                    const films = res.data;
                    this.setState({
                        films
                    });
                });
        }
    }

    getQueryJson() {
        var ip = require('ip');
        const postdata = '{' +
            '"query":"' + (this.state.isToggleOn ? 'Show machete view' : 'Show default view') + '",' +
            '"ip":"' + ip.address() + '"' +
            '}';
        return postdata;
    }

    componentDidMount() {
        axios.get("http://localhost:9095/getFilmOrder")
            .then(res => {
                const films = res.data;
                this.setState({
                    films
                });
            });
    }


    render() {
        if( this.state.films[0] === undefined ) {
            return <div>Loading...</div>
        }
        return (
            <div>



                <div className="container">
                    <div className="row mt-5">
                        <div className="col-sm-12">
                            <div id="machetebutton">
                                <button onClick={this.toggleFilms}>
                                    {this.state.isToggleOn ? 'Show machete order' : 'Show release order'}
                                </button>
                            </div>
                            <form onSubmit={this.handleFormSubmit}>




                { this.state.films.map(film =>
                    <div className="form-check">


                        <div id="filmtitle">{film.title}</div>
                        <div id="poster">
                            <img src={'http://img.omdbapi.com/?i='+film.imdb_id+'&apikey=57ec2f6d'} width='40%' ></img>
                            <div id="checkboxdiv">
                                <label>
                                    <input
                                        type="radio"
                                        name="react-tips"
                                        value={film.imdb_id}
                                        checked={this.state.selectedOption===film.imdb_id}
                                        onChange={this.handleOptionChange}
                                        className="form-check-input"
                                    />
                                </label>
                            </div>
                        </div>
                        <div id="actors">Actors: {film.actors}.</div>

                    </div>
                )}



                                <div className="form-group" id="savebttn">
                                    <button className="btn btn-primary mt-2" type="submit">
                                        Save my favourite film
                                    </button>
                                </div>


                            </form>

                        </div>
                    </div>
                </div>







            </div>
        )
    }
}
