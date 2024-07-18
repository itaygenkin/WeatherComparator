from flask import Flask, render_template, request
import requests
import plotly.express as px
app = Flask(__name__)


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'


@app.route('/fetch_weather', methods=['POST'])
def fetch_weather():
    location = request.args.get('location')
    start_date = request.args.get('start')
    end_date = request.args.get('end')
    url = f'http://localhost:8080/api/weather/comapre?location={location}&start_date={start_date}&end_date={end_date}'
    response = requests.get(url)
    data = response.json()

    # visualization
    fig = px.line(data, x='timestamp', y=['temperature', 'humidity'], title='Weather Comparison')
    graph_html = fig.to_html(full_html=False)

    return render_template('comparison.html', graph_html=graph_html)


if __name__ == '__main__':
    app.run()
