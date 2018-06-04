#slave.py

current_url = request_from_master()
to_send = []
for next_url in extract_urls(current_url):
    to_send.append(next_url)

store(current_url);
send_to_master(to_send)